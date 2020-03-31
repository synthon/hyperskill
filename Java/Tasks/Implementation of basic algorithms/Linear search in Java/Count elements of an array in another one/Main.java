import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] countOccurrences(int[] first, int[] second) {
        int[] out = new int[first.length];
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : second) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < out.length; i++) {
            out[i] = count.getOrDefault(first[i], 0);
        }

        return out;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final String result = Arrays.toString(countOccurrences(first, second))
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
        System.out.println(result);
    }
}
