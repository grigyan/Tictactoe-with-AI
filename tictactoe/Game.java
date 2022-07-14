package tictactoe;

import java.util.Scanner;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private final char[][] board = new char[3][3];

    public Game(Player p1, Player p2, String currentPosition) {
        playerOne = p1;
        playerTwo = p2;
        fillBoard(currentPosition);
    }

    public void playGame() {
        while (true) {
            printBoard();
            playerOne.makeMove(board);
            if (someoneWon(board)) {
                printBoard();
                break;
            }
            printBoard();
            playerTwo.makeMove(board);
            if (someoneWon(board)) {
                printBoard();
                break;
            }
        }
    }

    private void fillBoard(String cells) {
        int index = 0;  // charAt(index) from cells string
        // fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char currentChar = cells.charAt(index);
                board[i][j] = currentChar == '_' ? ' ' : currentChar;
                index++;
            }
        }
    }

    private void printBoard() {
        System.out.print("---------\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.print("---------\n");
    }

    private boolean someoneWon(char[][] board) {
        // horizontally
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')) {
                System.out.println("X wins");
                return true;
            }
            if ((board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')) {
                System.out.println("O wins");
                return true;
            }
        }

        // vertically
        for (int j = 0; j < 3; j++) {
            if ((board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')) {
                System.out.println("X wins");
                return true;
            }
            if ((board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')) {
                System.out.println("O wins");
                return true;
            }
        }

        // diagonally
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
            System.out.println("X wins");
            return true;
        }

        if ((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
            System.out.println("O wins");
            return true;
        }


        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;   // game not finished
                }
            }
        }

        // the only left case is:
        System.out.println("Draw");
        return true;
    }
}
