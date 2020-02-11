import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0, curr;
        int amount = sc.nextInt();

        for (int i = 0; i < amount; i++) {
            curr = sc.nextInt();

            if (curr % 4 == 0 && curr > max) max = curr;
        }

        System.out.println(max);
    }
}
