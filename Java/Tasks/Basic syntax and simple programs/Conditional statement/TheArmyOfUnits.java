import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x < 1) {
            System.out.println("no army");
        } else if (x < 20) {
            System.out.println("pack");
        } else if (x < 250) {
            System.out.println("throng");
        } else if (x < 1000) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}