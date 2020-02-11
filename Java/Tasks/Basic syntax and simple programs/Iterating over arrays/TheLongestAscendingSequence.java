import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];
        int maxLength = 1;
        int currLength = 1;

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 1; i < size; i++) {
            currLength = seq[i] > seq[i-1] ? ++currLength : 1;
            maxLength = Math.max(maxLength, currLength);
        }

        System.out.println(maxLength);
    }
}
