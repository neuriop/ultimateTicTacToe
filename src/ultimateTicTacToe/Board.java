package ultimateTicTacToe;

public class Board {

    private char[][] board = new char[10][9]; // this is standard size for a board, and should not be changed
    private boolean team;
    private final String xColor = "\u001B[34m"; // blue
    private final String oColor = "\u001B[31m"; // red
    private final String resetColor = "\u001B[0m"; // default color

    public Board() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 9; j++)
                this.board[i][j] = '-'; // defaults board to empty (-)
    }

    public void team() {
        this.team = !this.team;
    }

    public boolean getTeam() {
        return this.team;
    }

    public void setTile(int box, int tile) {
        board[box][tile] = this.team ? 'O' : 'X';
        team();
    }

    public boolean moveValidation(int box, int tile) {
        if (box >= 9 || box < 0) {
            System.out.println("Invalid move: box is not available.");
            return false;
        } else if (tile >= 9 || tile < 0) {
            System.out.println("Invalid move: tile is not available.");
            return false;
        } else if (board[box][tile] != '-') {
            System.out.println("Invalid move: tile is already captured.");
            return false;
        } else return true;
    }

    public boolean moveValidation(int box) {
        if (box >= 9 || box < 0) {
            System.out.println("Invalid move: box is not available.");
            return false;
        }
        return true;
    }

    public boolean winCondition(int box) {
        int j = 0;
        for (int i = 0; i < 3; i++) {
            if (board[box][i] == board[box][i + 3] && board[box][i] == board[box][i + 6] && board[box][i] != '-' && board[box][i] != '#') // Vertical check
                return true;
            if (board[box][j] == board[box][j + 1] && board[box][j] == board[box][j + 2] && board[box][j] != '-' && board[box][j] != '#') // Horizontal check
                return true;
            j += 3;
        }
        if (board[box][0] == board[box][4] && board[box][0] == board[box][8] && board[box][4] != '-' && board[box][4] != '#') // Diagonal check
            return true;
        if (board[box][2] == board[box][4] && board[box][2] == board[box][6] && board[box][4] != '-' && board[box][4] != '#') // Diagonal check
            return true;
        return false;
    }

    public boolean drawCondition(int box) { // checks if non captured box has empty tiles left
        for (int i = 0; i < 9; i++)
            if (board[box][i] == '-')
                return false;
        return true;
    }

    public void captureBox(int box, char player) { // captures board to certain player
        if (player == 'X') { // player X
            for (int i = 0; i < 8; i += 2) {
                board[box][i] = player;
                board[box][i + 1] = ' ';
            }
            board[box][8] = player;
        } else if (player == 'O') { // player O
            for (int i = 0; i < 8; i += 2) {
                board[box][i] = ' ';
                board[box][i + 1] = player;
            }
        } else { // none (draw)
            for (int i = 0; i < 9; i++) {
                board[box][i] = '#';
            }
        }
    }

    public void boardClear() { // clears board to its default state
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 9; j++)
                this.board[i][j] = '-';
    }

    public void boardOut(int box) { // idk how it works
        String color;
        int s = 0, l = 0;
        System.out.println("█████████████████████████");
        for (int q = 0; q < 3; q++) { // outputs next three boxes
            for (int k = 0; k < 3; k++) { // outputs next three rows of same three boxes
                System.out.print("█"); // puts this block in front of board
                for (int i = l; i < l + 3; i++) { // outputs first three rows of the first three boxes
                    System.out.print(" ");
                    for (int j = s; j < s + 3; j++) {
                        //System.out.print(i + " ");
                        if (board[i][j] == 'X')
                            color = xColor;
                        else if (board[i][j] == 'O')
                            color = oColor;
                        else
                            color = resetColor;
                        if (box >= 9 || box < 0)
                            System.out.print(board[i][j] + " ");
                        else if (i == box)
                            System.out.print(color + board[i][j] + " ");
                        else if (board[i][j] == '-')
                            System.out.print(" " + " ");
                        else
                            System.out.print(color + board[i][j] + " ");
                    }
                    System.out.print(resetColor + "█"); // puts this block after each box
                }
                s += 3; // skips to next three rows
                System.out.println();
            }
            s = 0; // resets to start from first row of the box
            l += 3; // skips to next three boxes
            System.out.println("█████████████████████████");
        }
    }

}
