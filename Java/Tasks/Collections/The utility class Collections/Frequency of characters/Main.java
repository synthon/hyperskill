import java.util.Scanner;
import java.util.List;
import java.util.Collections;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        List<String> arr = List.of(sc.nextLine().split("\\s+"));
        String elem = sc.nextLine();

        int freq = Collections.frequency(arr, elem);

        System.out.println(freq);
    }
}
