import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 1; i < size; i++) {
            if (seq[i] <= seq[i-1]) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
