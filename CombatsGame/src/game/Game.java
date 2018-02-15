package game;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player winner;

    private static final int HEAD = 40;
    private static final int CHEST = 30;
    private static final int STOMACH = 25;
    private static final int LEGS = 20;

    Scanner scanner = new Scanner(System.in);

    Game (String name1, String name2){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
    }

    public void round (){
        String kickOfPlayer1;
        String kickOfPlayer2;
        String defenseOfPlayer1;
        String defenseOfPlayer2;

        System.out.println("Player " + player1.getName() + " enter part of body, which you want to KICK");
        kickOfPlayer1 = receiveStepAndCheckIt();
        System.out.println("Player " + player2.getName() + " enter part of body, which you want to KICK");
        kickOfPlayer2 = receiveStepAndCheckIt();
        System.out.println("Player " + player1.getName() + " enter part of body, which you want to DEFENSE");
        defenseOfPlayer1 = receiveStepAndCheckIt();
        System.out.println("Player " + player2.getName() + " enter part of body, which you want to DEFENSE");
        defenseOfPlayer2 = receiveStepAndCheckIt();

        player1.reduceHealth(resultOfRound(defenseOfPlayer1, kickOfPlayer2));
        player2.reduceHealth(resultOfRound(defenseOfPlayer2, kickOfPlayer1));

        showResultsOfRound();
    }

    private int resultOfRound (String defenseOfPlayer, String kickOfPlayer )  {

        int kick = 0;
        int defense = 0;
        int resultOfRound;

        switch (kickOfPlayer){
            case ("head"):
                kick = HEAD;
                break;
            case ("chest"):
                kick = CHEST;
                break;
            case ("stomach"):
                kick = STOMACH;
                break;
            case ("legs"):
                kick = LEGS;
                break;
        }
        if (defenseOfPlayer.equals(kickOfPlayer)) {
            switch (defenseOfPlayer) {
                case ("head"):
                    defense = HEAD;
                    break;
                case ("chest"):
                    defense = CHEST;
                    break;
                case ("stomach"):
                    defense = STOMACH;
                    break;
                case ("legs"):
                    defense = LEGS;
                    break;
            }
        }
       resultOfRound = defense - kick;
       if (resultOfRound < 0){
           return resultOfRound*=-1;
       }

       return 0;

    }

    private String receiveStepAndCheckIt (){
        String step = scanner.nextLine();
        step = step.toLowerCase().trim();
        if (step.equals("head") || step.equals("chest") || step.equals("stomach") || step.equals("legs") ){
            return step;
        }
        while (true) {
            System.out.println("WARNING: wrong value was entered! Please enter correct value from next range: head; chest; stomach; legs ");
            step = scanner.nextLine();
            step = step.toLowerCase().trim();
            if (step.equals("head") || step.equals("chest") || step.equals("stomach") || step.equals("legs") ){
                return step;
            }
        }
    }

    private void showResultsOfRound() {

        System.out.println("Player " + player1.getName() + " at total of this round has health " + player1.getHealth());
        System.out.println("Player " + player2.getName() + " at total of this round has health " + player2.getHealth());

    }

    public boolean checkEndOfTheGame(){

        if (player1.getHealth() ==0 && player2.getHealth()>0){
            winner = player2;
            return false;
        }
        if (player2.getHealth() ==0 && player1.getHealth()>0){
            winner = player1;
            return false;
        }

        if (player1.getHealth() == 0 && player2.getHealth() ==0){
            return false;
        }

        return true;

    }

    public void resultOfGame(){
        System.out.println("GAME OVER");

        if (winner==null){
            System.out.println("DRAW!!!");
        } else{
            System.out.println("Winner is " + winner.getName().toUpperCase() + " !!!");
        }
    }


}
