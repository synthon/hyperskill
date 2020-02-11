import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] matrix = new String[n][n];

        for (int k = 0; k < n; k++) {
            for (int m = 0; m < n; m++) {
                matrix[k][m] = m == k || m == n - 1 - k || m == n / 2 || k == n / 2 ? "*" : ".";
            }
        }

        for (String[] i : matrix) {
            for (String k : i) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
