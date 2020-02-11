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

        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    c += 1;
                    if (c == k) {
                        System.out.println(i+1);
                        return;
                    }
                } else {
                    c = 0;
                }
            }
        }

        System.out.println(0);
    }
}
