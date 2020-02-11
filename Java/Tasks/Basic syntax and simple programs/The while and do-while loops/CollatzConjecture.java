import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curr = sc.nextInt();

        while (true) {
            System.out.print(curr + " ");
            
            if (curr == 1) break;

            if (curr % 2 == 0) {
                curr /= 2;
            } else {
                curr = curr * 3 + 1;
            }
        }
    }
}
