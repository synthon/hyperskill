import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int max = 0;

        for (int i = 0, num; i < a; i++) {
            num = sc.nextInt();
            if (num % 4 == 0 && num > max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}
