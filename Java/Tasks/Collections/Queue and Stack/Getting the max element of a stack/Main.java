import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max = new Stack<>();

        for (int i = 0; i < lines; i++) {
            String line = sc.nextLine();

            if (line.startsWith("push")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                stack.push(val);
                max.push(Math.max(val, max.isEmpty() ? Integer.MIN_VALUE : max.peek()));

            } else if ("pop".equals(line)) {
                stack.pop();
                max.pop();

            } else if ("max".equals(line)) {
                System.out.println(max.isEmpty() ? Integer.MIN_VALUE : max.peek());
            }
        }
    }
}
