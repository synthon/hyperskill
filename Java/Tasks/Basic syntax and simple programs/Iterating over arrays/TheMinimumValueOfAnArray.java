import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        int min = seq[0];
        for (int i : seq) {
            min = Math.min(i, min);
        }

        System.out.println(min);
    }
}
