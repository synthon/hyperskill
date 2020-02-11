import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int path = 0;

        int count = 1;
        while (count <= n*n) {
            int a = dirs[path%4][0];
            int b = dirs[path%4][1];

            if (x < 0 || y < 0 || x == n || y == n || matrix[x][y] != 0) {
                x -= a;
                y -= b;
                path += 1;
                a = dirs[path%4][0];
                b = dirs[path%4][1];
                x += a;
                y += b;
            }

            matrix[x][y] = count;
            x += a;
            y += b;

            count += 1;
        }

        for (int[] k : matrix) {
            for (int m : k) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }
}
