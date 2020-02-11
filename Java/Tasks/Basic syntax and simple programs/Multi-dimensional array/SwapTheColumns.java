import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int i = sc.nextInt();
        int j = sc.nextInt();

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (b == i) {
                    int temp = matrix[a][b];
                    matrix[a][b] = matrix[a][j];
                    matrix[a][j] = temp;
                }
            }
        }

        for (int[] a : matrix) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }
}
