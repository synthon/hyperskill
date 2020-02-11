import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        boolean answer = a + b == 20 || a + c == 20 || b + c == 20;

        System.out.println(answer);
    }
}
