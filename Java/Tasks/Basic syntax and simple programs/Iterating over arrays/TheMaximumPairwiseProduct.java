import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long product = 0;
        int prev = 1;
        int curr;

        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            curr = sc.nextInt();
            product = Math.max(curr * prev, product);
            prev = curr;
        }

        System.out.println(product);
    }
}
