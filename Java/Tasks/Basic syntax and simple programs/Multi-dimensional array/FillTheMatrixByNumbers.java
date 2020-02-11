import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.abs(i-j);
            }
        }

        for (int[] k : matrix) {
            for (int m : k) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}
