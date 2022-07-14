package tictactoe;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Player player1, player2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.split(" ").length == 3) {
                String[] inputArr = input.split(" ");
                String input1 = inputArr[1];
                String input2 = inputArr[2];

                switch (input1) {
                    case "easy":
                        player1 = new EasyAI('X');
                        break;
                    case "medium":
                        player1 = new MediumAI('X');
                        break;
                    case "hard":
                        player1 = new HardAI('X');
                        break;
                    default:
                        player1 = new User('X');
                        break;
                }

                switch (input2) {
                    case "easy":
                        player2 = new EasyAI('O');
                        break;
                    case "medium":
                        player2 = new MediumAI('O');
                        break;
                    case "hard":
                        player2 = new HardAI('O');
                        break;
                    default:
                        player2 = new User('O');
                        break;
                }

                new Game(player1, player2, "_________")
                        .playGame();

                break;
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }
}
