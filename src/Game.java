import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numberOfAttempts=5;
    private int totalAttempts=0;
    private int rounds=1;
    private int userInput;
    Random r =new Random();
    int randomNo;
    public Game(){
        randomNo=r.nextInt(101);


    }
    public void TotalAttempts(){
        totalAttempts++;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
    public int getRounds() {
        return rounds;
    }
    public int getUserInput() {
        return userInput;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }
    public void updateAttempts(){
        numberOfAttempts--;
        totalAttempts++;
    }
    public int getTotalAttempts() {
        return totalAttempts;
    }
    public int isCorrect(){
        if(this.userInput==this.randomNo){
            return 0;
        }
        else if(this.userInput> this.randomNo){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void resetAttempts()
    {
        this.numberOfAttempts=5;
    }
    public int calculateScore(){

        if(this.totalAttempts>=1 && this.totalAttempts<=3){

            return 100;

        }
        else if(this.totalAttempts>=4 && this.totalAttempts<=6){
            return 90;
        }
        else{
            return 80;
        }
    }
    public int calculateScore(int attempts){

        if(attempts==1){

            return 100;

        }
        else if(attempts==2){
            return 90;
        }
        else{
            return  80;
        }

    }
    public void nextRound() {
        rounds++;
        int randomNo2 = r.nextInt(201);
        int attempts = 8;
        Scanner sc = new Scanner(System.in);
        System.out.println("Round Number " + rounds);
        System.out.println("you have 8 chances in this round");
        boolean game = true;
        System.out.println("enter number between 1 and 200");
        String choice = "yes";
        for (int i = 1; i <= 5; i++) {

            while (game) {
                System.out.println("enter your guess");
                int number = sc.nextInt();

                if (number <= 0) {
                    System.out.println("please enter valid guess");
                    continue;
                }
                if (attempts <= 0) {

                    game = false;

                } else if (number == randomNo2) {

                    System.out.println("Congratulations ! you have guessed the correct number");
                    attempts++;
                    int score = calculateScore(attempts);
                    System.out.println("your score :"+score);
                    game = false;
                } else if (number > randomNo2) {
                    System.out.println("too large ! enter smaller number");
                    attempts++;
                } else {
                    System.out.println("too small ! enter larger number");
                    attempts++;
                }
            }
            System.out.println("do you want to play again ?");
            choice = sc.next();

            if (choice.equalsIgnoreCase("no")) {
                break;

            }


        }

    }

}
