import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        String input = sc.nextLine();

        while (!"end".equals(input)) {
            line += input + "\n";
            input = sc.nextLine();
        }

        String[] badInput = line.split("\n");
        int badInputLength = badInput.length;
        String[][] matrix = new String[badInputLength][];

        for (int i = 0; i < badInputLength; i++) {
            matrix[i] = badInput[i].split(" ");
        }

        int rowLength = matrix[0].length;
        int colomnLength = matrix.length;

        for (int i = 0; i < colomnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                int up = Integer.parseInt(matrix[(i - 1 + colomnLength) % colomnLength][j]);
                int down = Integer.parseInt(matrix[(i + 1 + colomnLength) % colomnLength][j]);
                int left = Integer.parseInt(matrix[i][(j - 1 + rowLength) % rowLength]);
                int right = Integer.parseInt(matrix[i][(j + 1 + rowLength) % rowLength]);
                System.out.print(up + down + left + right + " ");
            }
            System.out.println();
        }
    }
}
