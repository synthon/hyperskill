import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        long prod = 1;

        for (int i = start; i < end; i++) {
            prod *= i;
        }

        System.out.println(prod);
    }
}
