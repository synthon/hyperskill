import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        List<String> out = List.of(sc.nextLine().split("\\s+"));

        System.out.println(out);
    }
}
