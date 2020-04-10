import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        List<String> arr = Arrays.stream(sc.nextLine().split("\\s+"))
            .collect(Collectors.toList());

        int swaps = sc.nextInt();
        for (int s = 0; s < swaps; s++) {
            Collections.swap(arr, sc.nextInt(), sc.nextInt());
        }

        arr.forEach(e -> System.out.printf("%s ", e));
    }
}
