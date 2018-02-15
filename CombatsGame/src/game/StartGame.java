package game;

import java.util.Scanner;

public class StartGame {

    public static void main(String[] args) {

        String player1;
        String player2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, please, enter your name");
        player1 = scanner.nextLine();
        System.out.println("Player 2, please, enter your name");
        player2 = scanner.nextLine();

        Game game = new Game(player1, player2);

        while (game.checkEndOfTheGame()){
            game.round();
        }

        game.resultOfGame();

    }

}
