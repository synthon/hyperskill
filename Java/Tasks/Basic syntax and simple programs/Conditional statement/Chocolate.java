import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (c < a*b && c > 0 && (c % a < 1 || c % b < 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
