import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong(), f = 1, i = 1;

        for (i = f; f <= num; i++) f *= i;

        System.out.println(i-1);
    }
}
