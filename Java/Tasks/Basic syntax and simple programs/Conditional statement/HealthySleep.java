import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (c < a) {
            System.out.println("Deficiency");
        } else if (c > b) {
            System.out.println("Excess");
        } else {
            System.out.println("Normal");
        }
    }
}
