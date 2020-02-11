import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x%10*10 + x%100/10 == x/100) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}
