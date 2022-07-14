package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class HardAI extends Player {

    private char opponentMark;

    class Move {
        private int x;
        private int y;
        private int score;

        public Move(int score) {
            this.score = score;
        }

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public HardAI(char mark) {
        super(mark);

        if (this.mark == 'X') {
            opponentMark = 'O';
        } else {
            opponentMark = 'X';
        }
    }


    @Override
    public void makeMove(char[][] board) {
        System.out.println("Making move level \"hard\"");
        Move moveToMake = minimax(board, this.mark);
        int x = moveToMake.getX();
        int y = moveToMake.getY();
        board[x][y] = this.mark;
    }

    public Move minimax(char[][] newBoard, char mark) {
        var availableMoves = availableMoves(newBoard);

        int score = -1;
        if (winning(newBoard, this.mark)) {
            score = 10;
            return new Move(score);
        } else if (winning(newBoard, opponentMark)) {
            score = -10;
            return new Move(score);
        } else if (availableMoves.size() == 0) {
            score = 0;
            return new Move(score);
        }

        List<Move> moves = new ArrayList<>();

        for (Move nextMove : availableMoves) {
            int x = nextMove.getX();
            int y = nextMove.getY();
            newBoard[x][y] = mark;

            if (mark == this.mark) {
                var result = minimax(newBoard, this.opponentMark).getScore();
                nextMove.setScore(result);
            } else {
                var result = minimax(newBoard, this.mark).getScore();
                nextMove.setScore(result);
            }

            newBoard[x][y] = ' ';
            moves.add(nextMove);
        }

        Move bestMove = null;
        if (mark == this.mark) {
            int maxValue = Integer.MIN_VALUE;
            for (Move m : moves) {
                if (m.getScore() > maxValue) {
                    bestMove = m;
                    maxValue = m.getScore();
                }
            }
        } else {
            int minValue = Integer.MAX_VALUE;
            for (Move m : moves) {
                if (m.getScore() < minValue) {
                    bestMove = m;
                    minValue = m.getScore();
                }
            }
        }

        return bestMove;
    }


    // list of available coordinates
    private List<Move> availableMoves(char[][] board) {
        List<Move> availableCoordinates = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    availableCoordinates.add(new Move(i, j));
                }
            }
        }

        return availableCoordinates;
    }

    // true if board is in winning state for the given mark X or O
    private boolean winning(char[][] board, char mark) {
        // horizontally
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark)) {
                return true;
            }
        }

        // vertically
        for (int j = 0; j < 3; j++) {
            if ((board[0][j] == mark && board[1][j] == mark && board[2][j] == mark)) {
                return true;
            }
        }

        // diagonally
        if ((board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)) {
            return true;
        } else {
            return false;
        }
    }
}


