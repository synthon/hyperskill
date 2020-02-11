import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];

        for (int i = 0; i < size; i++) {
            seq[(i+1)%size] = sc.nextInt();
        }

        for (int i : seq) {
            System.out.print(i + " ");
        }
    }
}
