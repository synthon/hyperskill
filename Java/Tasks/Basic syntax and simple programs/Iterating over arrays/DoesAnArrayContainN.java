import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] seq = new int[size];

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        int element = sc.nextInt();

        for (int i : seq) {
            if (i == element) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }
}
