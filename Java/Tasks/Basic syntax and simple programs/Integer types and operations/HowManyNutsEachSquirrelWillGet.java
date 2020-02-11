import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squirrel = scanner.nextInt();
        int totalNuts = scanner.nextInt();
        int nuts = totalNuts/squirrel;

        System.out.println(nuts);
    }
}
