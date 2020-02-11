import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double m = sc.nextInt();
        double p = sc.nextInt();
        double k = sc.nextInt();
        int y = 0;

        while (m < k) {
            m *= 1 + p/100;
            y++;
        }

        System.out.println(y);

    }
}
