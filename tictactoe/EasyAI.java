package tictactoe;

import java.util.Random;

public class EasyAI extends Player{
    public EasyAI(char mark) {
        super(mark);
    }

    @Override
    public void makeMove(char[][] board) {
        System.out.println("Making move level \"easy\"");
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
