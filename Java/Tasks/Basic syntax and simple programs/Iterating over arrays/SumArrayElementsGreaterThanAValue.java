import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();
        }

        int element = sc.nextInt();
        for (int el : seq) {
            if (el > element) {
                sum += el;
            }
        }

        System.out.println(sum);
    }
}
