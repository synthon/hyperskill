import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxI = 0;
        int maxJ = 0;

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();

                if (matrix[i][j] > matrix[maxI][maxJ]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println(maxI + " " + maxJ);
    }
}
