import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prev = "";

        for (String s : sc.nextLine().split(" ")) {
            if (s.compareTo(prev) < 0) {
                System.out.println(false);
                return;
            }
            prev = s;
        }

        System.out.println(true);
    }
}
