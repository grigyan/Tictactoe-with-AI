package tictactoe;

public abstract class Player {
    char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public abstract void makeMove(char[][] board);
}
