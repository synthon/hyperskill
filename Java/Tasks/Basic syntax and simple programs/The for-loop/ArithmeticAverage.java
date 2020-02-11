import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = 0;
        int d = 0;

        for (a = a; a <= b; a++) {
            if (a % 3 == 0) {
                c += a;
                d++;
            }
        }

        System.out.println(c/d);
    }
}
