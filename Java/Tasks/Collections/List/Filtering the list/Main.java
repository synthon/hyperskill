import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        List<String> out = List.of(sc.nextLine().split("\\s+"));

        for (int i = out.size() - 1; i > -1; i--) {
            if (i % 2 != 0) {
                System.out.printf("%s ", out.get(i));
            }
        }
    }
}
