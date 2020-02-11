import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = sc.nextInt(), num;

        while (true) {
            num = sc.nextInt();

            if (num == 0) {
                break;
            } else {
                if (num > max) {
                    max = num;
                }
            }
        }

        System.out.println(max);

    }
}
