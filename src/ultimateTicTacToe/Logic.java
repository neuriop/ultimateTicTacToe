package ultimateTicTacToe;

import java.util.Scanner;

public class Logic {

    private static final Scanner input = new Scanner(System.in);

    public static void game(){
        Board board = new Board();
        board.boardOut(9);
        char currentPlayer = board.getTeam() ? 'O' : 'X';
        System.out.println("Current player: " + currentPlayer);
        System.out.println("Insert box number 1-9 ");
        int box;
        do {
            box = input.nextInt() - 1;
        } while (!board.moveValidation(box));
        board.boardOut(box);
        System.out.println("Insert tile number 1-9 ");
        int tile;
        do {
            tile = input.nextInt() - 1;
        } while (!board.moveValidation(box, tile));
        board.setTile(box, tile);
        board.boardOut(9);
        box = tile;

        do {
            currentPlayer = board.getTeam() ? 'O' : 'X';
            if (board.drawCondition(box)) {
                System.out.print("There is no empty tiles left in " + box + " box, so, ");
                System.out.println(currentPlayer + ": Insert box number 1-9 ");
                board.boardOut(9);
                do {
                    box = input.nextInt() - 1;
                } while (!board.moveValidation(box));
            }
            board.boardOut(box);
            System.out.println(currentPlayer + ": Insert tile number 1-9 ");
            do {
                tile = input.nextInt() - 1;
            } while (!board.moveValidation(box, tile));
            board.setTile(box, tile);
            if (board.drawCondition(box))
                board.captureBox(box, '#');
            if (board.winCondition(box))
                board.captureBox(box, currentPlayer);
            box = tile;

            if (board.drawCondition(9))
                System.out.println("DRAW!");
            if (board.winCondition(9))
                System.out.println(currentPlayer + " WINS!");

        } while (!(board.winCondition(9) && board.drawCondition(9)));
    }

}
