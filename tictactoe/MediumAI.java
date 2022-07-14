package tictactoe;

import java.util.Random;

public class MediumAI extends Player{
    private char opponentMark;

    public MediumAI(char mark) {
        super(mark);

        if (this.mark == 'X') {
            opponentMark = 'O';
        } else {
            opponentMark = 'X';
        }
    }

    @Override
    public void makeMove(char[][] board) {
        // if it has two in a row and can win with one move it does so
        if (horizontalAction(board, mark) || verticalAction(board, mark) || diagonalAction(board, mark)) {
            System.out.println("Making move level \"medium\"");
        } else if (horizontalAction(board, opponentMark) || verticalAction(board, opponentMark)
                || diagonalAction(board, opponentMark)) {   // block opponent's win
            System.out.println("Making move level \"medium\"");
        } else {
            // random move
            System.out.println("Making move level \"medium\"");
            Random random = new Random();
            while (true) {
                int x = random.nextInt(3);
                int y = random.nextInt(3);
                if (board[x][y] == ' ') {
                    board[x][y] = this.mark;
                    break;
                }
            }
        }
    }

    private boolean horizontalAction(char[][] board, char mark) {
        for (char[] row : board) {
            if (row[0] == mark && row[1] == mark && row[2] == ' ') {
                row[2] = this.mark;
                return true;
            } else if (row[0] == mark && row[1] == ' ' && row[2] == mark) {
                row[1] = this.mark;
                return true;
            } else if (row[0] == ' ' && row[1] == mark && row[2] == mark) {
                row[0] = this.mark;
                return true;
            }
        }

        return false;
    }

    private boolean verticalAction(char[][] board, char mark) {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == ' ') {
                board[2][j] = this.mark;
                return true;
            } else if (board[0][j] == mark && board[1][j] == ' ' && board[2][j] == mark) {
                board[1][j] = this.mark;
                return true;
            } else if (board[0][j] == ' ' && board[1][j] == mark && board[2][j] == mark) {
                board[0][j] = this.mark;
                return true;
            }
        }

        return false;
    }

    private boolean diagonalAction(char[][] board, char mark) {
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == ' ') {
            board[2][2] = this.mark;
            return true;
        } else if (board[0][0] == mark && board[1][1] == ' ' && board[2][2] == mark) {
            board[1][1] = this.mark;
            return true;
        } else if (board[0][0] == ' ' && board[1][1] == mark && board[2][2] == mark) {
            board[0][0] = this.mark;
            return true;
        } else if (board[0][2] == mark && board[1][1] == mark && board[2][0] == ' ') {
            board[2][0] = this.mark;
            return true;
        } else if (board[0][2] == mark && board[1][1] == ' ' && board[2][0] == mark) {
            board[1][1] = this.mark;
            return true;
        } else if (board[0][2] == ' ' &&  board[1][1] == mark && board[2][0] == mark) {
            board[0][2] = this.mark;
            return true;
        }

        return false;
    }
}
