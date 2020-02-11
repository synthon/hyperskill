import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int curr = sc.nextInt();

        while (curr != 0) {
            count++;
            curr = sc.nextInt();
        }

        System.out.println(count);
    }
}
