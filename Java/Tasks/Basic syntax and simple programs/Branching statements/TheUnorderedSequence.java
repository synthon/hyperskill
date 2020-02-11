import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inc = 0, dec = 0, next;
        int curr = sc.nextInt();

        while (true) {
            next = sc.nextInt();

            if (next == 0) break;

            if (next < curr) dec = 1;
            if (next > curr) inc = 1;

            curr = next;
        }

        System.out.println(inc * dec < 1);
    }
}
