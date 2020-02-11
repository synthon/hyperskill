import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];
        int triplet = 0;

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < size-2; i++) {
            if (seq[i] + 1 == seq[i+1] && seq[i+1] + 1 == seq[i+2]) {
                triplet += 1;
            }
        }

        System.out.println(triplet);
    }
}
