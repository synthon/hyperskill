import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        boolean answer = num < 10 && num > 0;

        System.out.println(answer);
    }
}
