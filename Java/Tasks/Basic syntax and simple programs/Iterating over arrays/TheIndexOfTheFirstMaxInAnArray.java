import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] seq = new int[size];

        for (int i = 0; i < size; i++) {
            seq[i] = sc.nextInt();    
        }

        int max = seq[0];
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (max < seq[i]) {
                index = i;
                max = seq[i];
            }
        }

        System.out.println(index);
    }
}
