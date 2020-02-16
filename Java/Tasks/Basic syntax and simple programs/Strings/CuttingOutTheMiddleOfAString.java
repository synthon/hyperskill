import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            if (!(len % 2 == 0 && i == len / 2  - 1 || i == len / 2)) {
                System.out.print(input.charAt(i));
            }
        }
    }
}
