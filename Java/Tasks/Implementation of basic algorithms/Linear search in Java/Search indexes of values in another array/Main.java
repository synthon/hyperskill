import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static int[] searchIndexes(int[] first, int[] second) {
        int[] indexes = new int[first.length];
        HashMap<Integer, Integer> ind = new HashMap<>();

        for (int i = 0; i < second.length; i++) {
            ind.put(second[i], ind.getOrDefault(second[i], i));
        }

        for (int i = 0; i < first.length; i++) {
            indexes[i] = ind.getOrDefault(first[i], -1);
        }

        return indexes;
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
        final String result = Arrays.toString(searchIndexes(first, second))
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
        System.out.println(result);
    }
}
