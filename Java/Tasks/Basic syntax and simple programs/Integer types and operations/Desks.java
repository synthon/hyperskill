import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        int cr1 = num1 + num1%2;
        int cr2 = num2 + num2%2;
        int cr3 = num3 + num3%2;
        
        int tables = (cr1 + cr2 + cr3)/2;
        
        System.out.println(tables);
    }
}
