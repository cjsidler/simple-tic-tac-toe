package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char currentPlayer = 'X';

        // Generate a multidimensional array representing the game board
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = ' ';
            }
        }

        printGameBoard(gameBoard);

        while (true) {
            // Get a valid move
            while (true) {
                try {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (x > 3 || x < 1 || y > 3 || y < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (gameBoard[x - 1][y - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        gameBoard[x - 1][y - 1] = currentPlayer;
                        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                    scanner.next();
                }
            }

            printGameBoard(gameBoard);

            // Check if we have a winner or a draw
            boolean XWins = isWinner(gameBoard, 'X');
            boolean OWins = isWinner(gameBoard, 'O');
            boolean isDraw = determineIfGameIsADraw(gameBoard);

            if (XWins) {
                System.out.println("X wins");
                break;
            } else if (OWins) {
                System.out.println("O wins");
                break;
            } else if (isDraw) {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n",
                gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        System.out.printf("| %c %c %c |%n",
                gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        System.out.printf("| %c %c %c |%n",
                gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);
        System.out.println("---------");
    }

    public static boolean isWinner(char[][] gameBoard, char player) {
        for (int i = 0; i < 3; i++) {
            boolean winRow = true;
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] != player) {
                    winRow = false;
                    break;
                }
            }
            if (winRow) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            boolean winCol = true;
            for (int j = 0; j < 3; j++) {
                if (gameBoard[j][i] != player) {
                    winCol = false;
                    break;
                }
            }
            if (winCol) {
                return true;
            }
        }

        boolean winTopDiag = true;
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][i] != player) {
                winTopDiag = false;
                break;
            }
        }
        boolean winBotDiag = true;
        for (int i = 2; i >= 0; i--) {
            if (gameBoard[i][Math.abs(i - 2)] != player) {
                winBotDiag = false;
                break;
            }
        }
        return winTopDiag || winBotDiag;
    }

    private static boolean determineIfGameIsADraw(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
