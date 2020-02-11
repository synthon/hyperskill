import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        String op = sc.next();
        long b = sc.nextLong();

        switch (op) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Division by 0!");
                    break;
                } else {
                    System.out.println(a / b);
                    break;
                }
            case "*":
                System.out.println(a * b);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}
