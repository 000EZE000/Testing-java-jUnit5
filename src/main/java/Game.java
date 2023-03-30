import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

public class Game {



    private final static String ROCK = "rock";
    private final static String PAPER = "paper";
    private final static String SCISSORS = "scissors";
    private final static String QUIT = "quit";


    private  String choice;
    private final static String MESSAGE_START = "Let's play Rock, Paper, Scissors! \n " +
            "Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.";
    private final static String MESSAGE_BAD_INPUT = "Sorry, it looks like you didn't enter a correct input. Try again.";


    private static int tieCounter = 0;
    private static int winUserCounter = 0;
    private static int lossUserCounter = 0;


    private  Scanner input = new Scanner(System.in);
    private  Random random = new Random();

    public void play() {

        getTitleGame(MESSAGE_START);

        String choiceUser = getChoiceUser();

        String choiceComputer = getChoiceComputer();

        if(choiceUser.equals(QUIT)) return;

        System.out.println(ROCK +  choiceUser);
        while (!choiceUser.equals("quit")) {

            printChoiceComputer(choiceComputer);
            tieCounter = ifTheyTie(choiceUser,choiceComputer, tieCounter);
            winUserCounter = addIfUserWon(choiceUser, choiceComputer, winUserCounter);
            lossUserCounter = addIfComputerWon(choiceComputer, choiceUser, lossUserCounter );

            printResultChoice(tieCounter,winUserCounter,lossUserCounter);
            getTitleGame(MESSAGE_START);
            choiceUser = getChoiceUser();
        }

    }

    public void getTitleGame(String inputMessage){
        System.out.println(inputMessage);
    }


    public  String getChoiceComputer() {
        int  randomForThree = (int) (random.nextInt(3)) + 1;
        return   randomForThree == 1 ? ROCK :
                        randomForThree == 2 ? PAPER : SCISSORS;
    }



    public  void printChoiceComputer(String choiceComputer){
        System.out.println("Computer chose " + choiceComputer);
    }

    public  void  printResultChoice(int tieCounter, int winUserCounter , int lossUserCounter ){
        System.out.println("wins:" + winUserCounter + "\nloses:" + lossUserCounter + "\nties:" + tieCounter  + " \t \n Let's play again! \n \n");
    }

    public boolean choiceComparison(String winner, String loser) {
        return (winner.equals(ROCK) && loser.equals(SCISSORS)) ||
                    (winner.equals(SCISSORS) && loser.equals(PAPER)) ||
                           ( winner.equals(PAPER) && loser.equals(ROCK));

    }

    public  boolean compare(String s, String a) {
        return  s.equals(a);
    }

    public  boolean wrongUserInput(String input) {
        return   input.equals(ROCK) ? false :
                    input.equals(PAPER) ? false :
                            input.equals(SCISSORS) ? false : true ;
    }

    public int addIfUserWon(String winner,String loser,int timesWon){
        int back = timesWon;
        if(choiceComparison(winner, loser)) {
            System.out.println("you win!");
            back = +1;
        };
        return back;

    }

    public int addIfComputerWon(String winner,String loser, int timesWon){
        int back = timesWon;
        if(choiceComparison(winner, loser)) {
            System.out.println("you lose.");
            back =+ 1 ;
        };
        return back;

    }

    public int ifTheyTie(String winner,String loser, int timesWon){
        int back = timesWon;
        if(winner.equals(loser)) {
            System.out.println("It's a tie");
            back = +1;
        };
        return back;

    }



    public String getChoiceUser(){
        String  choiceUser = input.nextLine().toLowerCase();
            while(wrongUserInput(choiceUser)) {
                getTitleGame(MESSAGE_BAD_INPUT);
                choiceUser = input.nextLine().toLowerCase();
                if (choiceUser.equals(QUIT)) return QUIT;
            }
        return  choiceUser;
    }


}