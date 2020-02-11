import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int[][] field = new int[x*x][x*x];

        for (int i = 0; i < x*x; i++) {
            for (int j = 0; j < x*x; j++) {
                int num = sc.nextInt();

                if (num < 1 || num > x*x) {
                    System.out.println("NO");
                    return;
                }

                field[i][j] = num;
            }
        }

        for (int i = 0; i < x*x; i++) {
            int[] row = new int[x*x+1];
            int[] column = new int[x*x+1];
            int[] square = new int[x*x+1];

            for (int j = 0; j < x*x; j++) {
                int numRow = field[i][j];
                int numColumn = field[j][i];
                int numSquare = field[j/x+x*(i/x)][j%x+x*(i%x)];

                if (row[numRow] != 0 || column[numColumn] != 0 || square[numSquare] != 0) {
                    System.out.println("NO");
                    return;
                } else {
                    row[numRow] = 1;
                    column[numColumn] = 1;
                    square[numSquare] = 1;
                }
            }
        }

        System.out.println("YES");
    }
}
