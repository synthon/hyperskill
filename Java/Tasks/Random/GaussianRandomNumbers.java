import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        double m = sc.nextDouble();

        while (true) {
            Random generate = new Random(k);
            int r = n;

            for (int i = 0; i < n; i++) {
                double gauss = generate.nextGaussian();
                if (gauss <= m) {
                    r -= 1;
                }
            }

            if (r == 0) {
                System.out.println(k);
                return;
            }

            k += 1;
        }
    }
}