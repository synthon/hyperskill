import java.util.*;

public class Main {
    public static void sort(int[] numbers) {
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (var pair : count.entrySet()) {
            int tmp = pair.getValue();

            while (tmp > 0) {
                numbers[index] = pair.getKey();
                tmp -= 1;
                index += 1;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
