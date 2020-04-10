import java.util.Scanner;
import java.util.List;
import java.util.Collections;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        List<String> arr = List.of(sc.nextLine().split("\\s+"));
        List<String> sub = List.of(sc.nextLine().split("\\s+"));

        System.out.printf(
            "%s %s",
            Collections.indexOfSubList(arr, sub),
            Collections.lastIndexOfSubList(arr, sub)
        );
    }
}
