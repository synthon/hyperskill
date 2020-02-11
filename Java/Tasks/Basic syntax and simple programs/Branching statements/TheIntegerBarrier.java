import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long sum = 0, curr;

        while (true) {
            curr = sc.nextLong();

            sum += curr;

            if (curr == 0) {
                System.out.println(sum);
                return;
            }

            if (sum >= 1000) {
                System.out.println(sum - 1000);
                return;
            }
        }
    }
}
