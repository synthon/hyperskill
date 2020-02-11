import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 0; num > 0; i++) {
            for (int j = i; j < i + i && num > 0; j++, num--) {
                System.out.print(i + " ");
            }
        }
    }
}
