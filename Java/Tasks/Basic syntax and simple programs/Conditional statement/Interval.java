import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x > -15 && x < 13 || x > 14 && x < 17 || x > 18) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
