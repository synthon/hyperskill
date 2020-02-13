import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        Random generate = new Random(a + b);

        for (int i = 0; i < n; i++) {
            sum += generate.nextInt(b - a + 1) + a;
        }

        System.out.println(sum);
    }
}
