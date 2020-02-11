import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean b = sc.nextBoolean();

        boolean ans1 = a > 9 && a < 21 && !b;
        boolean ans2 = a > 14 && a < 26 && b;

        System.out.println(ans1 || ans2);
    }
}
