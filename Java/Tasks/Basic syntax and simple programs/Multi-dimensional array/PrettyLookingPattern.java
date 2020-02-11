import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] matrix = new String[4][];
        Boolean pretty = true;

        for (int i = 0; i < 4; i++) {
            matrix[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((matrix[i][j] + matrix[i][j+1]).equals(matrix[i+1][j] + matrix[i+1][j+1])) {
                    pretty = false;
                    break;
                }
            }
        }

        System.out.println(pretty ? "YES" : "NO");
    }
}
