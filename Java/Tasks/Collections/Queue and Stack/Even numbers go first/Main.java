import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0 ; i < size; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                deque.push(num);
            } else {
                deque.add(num);
            }
        }

        deque.forEach(System.out::println);
    }
}
