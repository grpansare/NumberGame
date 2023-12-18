import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to Number Game");

        int userInput;

        boolean gameOn = true;
        Game game = new Game();

        int rounds = game.getRounds();

        System.out.println("let's Start the game ");
        for (int i = 1; i <= 5; i++) {
            String choice="yes";
            int score=0;
            int round= game.getRounds();
            System.out.println("you have 5 chances to guess the number");
            gameOn=true;
            game.resetAttempts();
            while (gameOn) {

                int attempts = game.getNumberOfAttempts();

                if (attempts <= 0) {

                    gameOn = false;

                }
                else {
                    System.out.println("guess the number");
                    userInput = sc.nextInt();
                    if(userInput<=0){
                        System.out.println("please enter valid guess");
                        continue;
                    }
                    else {

                        game.setUserInput(userInput);
                        int result = game.isCorrect();

                        if (result == 0) {
                            System.out.println("Congratulations ! you have guessed the correct number");
                            game.updateAttempts();

                            score = game.calculateScore();
                            System.out.println("your score "+score);
                            System.out.println("do you want to play next round ?");
                            String ch1=sc.next();
                            if(ch1.equalsIgnoreCase("yes")){
                                game.nextRound();

                            }

                            break;


                        } else if (result == 1) {
                            System.out.println("too large ! Enter smaller number");
                            game.updateAttempts();

                            System.out.println("number of attempts remained :" + game.getNumberOfAttempts());
                        } else if (result == -1) {
                            System.out.println("too small ! enter large number");
                            game.updateAttempts();
                            System.out.println("number of attempts remained :" + game.getNumberOfAttempts());
                        }
                    }
                }}

            System.out.println("do you want to play again ?");
            choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
                break;

            }


        }

    }
}
