package tictactoe;

import java.util.Scanner;

public class User extends Player{

    public User(char mark) {
        super(mark);
    }

    @Override
    public void makeMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        // make a move
        while (true) {
            System.out.print("Enter the coordinates: > ");
            int c1, c2;

            try {
                c1 = Integer.parseInt(scanner.next());
                c2 = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers");
                continue;
            }

            if (c1 > 3 || c2 > 3) {
                System.out.print("Coordinates should be from 1 to 3!\n");
            } else if (board[c1 - 1][c2 - 1] != ' ') {
                System.out.print("This cell is occupied! Choose another one!\n");
            } else {
                board[c1 - 1][c2 - 1] = this.mark;
                break;
            }
        }
    }
}
