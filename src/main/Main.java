package main;

import ultimateTicTacToe.Logic;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean exit = true;
        String menu;
        Scanner input = new Scanner(System.in);


        do {
            System.out.println("Enter menu option: \"play\", \"help\", \"exit\"");
            menu = input.nextLine().toLowerCase();
            switch (menu) {
                case "play":
                        Logic.game();
                    break;

                case "help":
                    System.out.print("How to play ultimate tic-tac-toe.\n" +
                            "Firstly you need to understand the basics. To play a tic-tac-toe you need to put three of your figures (X or O) three in a row, in either a vertical, horizontal or diagonal direction.\n" +
                            "This game takes it further. The board consist out of nine smaller boards. After winning in one smaller board, it captures to your sign.\n" +
                            "So in order win, you must capture three boards in the row, in either vertical, horizontal or diagonal direction.\n" +
                            "To play this game you must enter a number (1-9) to specify which tile you want to put your figure to.\n" +
                            "Then second player can put their sign at any tile of the board of the tile you placed your figure. So, if you chose to place your sign at second tile, your opponent must place their figure on second board.\n" +
                            "If board has no empty tiles left, player can chose any board to play on.\n" +
                            "This is how board map looks like\n" +
                            "1 2 3\n" +
                            "4 5 6\n" +
                            "7 8 9\n" +
                            "Each number represents both the number of the board, and the tile of this board.\n");
                    break;

                case "exit":
                    exit = false;
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }
        } while (exit);
    }
}