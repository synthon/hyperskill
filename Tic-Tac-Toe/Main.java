package tictactoe;

import java.util.*;

public class Main {
    private static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("| %c %c %c |", field[i][0], field[i][1], field[i][2]));
        }
        System.out.println("---------");
    }

    private static void nextMove(char[][] field, int skin) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the coordinates: ");

            char[] move = sc.nextLine().toCharArray();
            Boolean invalid = false;

            for (int n : move) {
                if ((n < 48 || n > 57) && n != 32) {
                    System.out.println("You should enter numbers!");
                    invalid = true;
                    break;
                }
            }
            if (!invalid) {
                if (move.length == 3 && move[1] == ' ') {
                    if ((move[0] > 48 && move[0] < 52) && (move[2] > 48 && move[2] < 52)) {
                        int x = move[0] - 48;
                        int y = move[2] - 48;

                        if (field[3-y][x-1] == ' ') {
                            field[3-y][x-1] = skin > 0 ? 'O' : 'X';
                            break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        }
                    }
                }
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

    private static void gameState(char[][] field) {
        Boolean xxx = false;
        Boolean ooo = false;
        int xs = 0;
        int os = 0;
        int skin = 0;

        while (true) {
            printField(field);
            nextMove(field, skin);

            for (int i = 0; i < 3; i++) {
                int row = 0;
                int clm = 0;
                int mDiag = 0;
                int aDiag = 0;

                for (int j = 0; j < 3; j++) {
                    row += field[i][j];
                    clm += field[j][i];
                    mDiag += field[j][j];
                    aDiag += field[j][2-j];
                }

                // ASCII value for X is 88 (X+X+X is 264, win for X)
                // ASCII value for O is 79 (O+O+O is 237, win for O)
                xxx = xxx || row == 264 || clm == 264 || mDiag == 264 || aDiag == 264;
                ooo = ooo || row == 237 || clm == 237 || mDiag == 237 || aDiag == 237;
            }

            xs += skin;
            os += skin;
            skin ^= 1;

            if (xxx || ooo || (xs + os == 9)) {
                printField(field);
                System.out.println(xxx ? "X wins" : ooo ? "O wins" : "Draw");
                return;
            }
        }
    }

    public static void main(String[] args) {
        char[][] field = new char[3][3];

        for (int i = 0; i < 9; i++) {
            field[i/3][i%3] = ' ';
        }

        gameState(field);
    }
}