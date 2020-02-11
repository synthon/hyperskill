import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int s = 0, f = 0, r = 0; // ship, fix, reject

        for (int i = 0, part; i < size; i++) {
            part = sc.nextInt();

            if (part > 0) f++;
            else if (part < 0) r++;
            else s++;
        }

        System.out.println(s + " " + f + " " + r);
    }
}
