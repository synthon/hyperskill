import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int count = 0;

        for (int i = 0, l = num.length(); i < l/2; i++) {
            count += num.charAt(i) - num.charAt(~i+l);
        }

        System.out.println(count == 0 ? "YES" : "NO");
    }
}
