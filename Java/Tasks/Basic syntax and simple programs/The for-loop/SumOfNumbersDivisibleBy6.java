import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int sum = 0;

        for (int i = 0, num; i < a; i++) {
            num = sc.nextInt();
            if (num % 6 == 0) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
