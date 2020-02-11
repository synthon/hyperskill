import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int heightOfBus = sc.nextInt();
        int amoutOfBridges = sc.nextInt();

        for (int i = 0; i < amoutOfBridges; i++) {
            if (sc.nextInt() <= heightOfBus) {
                System.out.println("Will crash on bridge " + (i + 1));
                return;
            }
        }

        System.out.println("Will not crash");
    }
}
