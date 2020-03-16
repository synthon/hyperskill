import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int lines = sc.nextInt();

        for (int i = 0; i < lines; i++) {
            queue.offer(sc.nextInt());
        }

        for (int i = 0; i < lines; i++) {
            System.out.println(queue.pollLast());
        }
    }
}
