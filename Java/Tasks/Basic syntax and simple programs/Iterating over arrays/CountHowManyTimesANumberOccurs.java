import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int find = sc.nextInt();
        for (int i : arr) {
            if (i == find) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
