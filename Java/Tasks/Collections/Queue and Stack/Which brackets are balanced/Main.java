import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, String> braces = new HashMap<>(Map.of(
            "]", "[",
            ")", "(",
            "}", "{"
        ));

        for (String i : input.split("")) {
            if (braces.containsValue(i)) {
                queue.offer(i);
            } else {
                if (!braces.get(i).equals(queue.pollLast())) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(queue.isEmpty() ? true : false);
    }
}
