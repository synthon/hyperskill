import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        int length = s.length();

        if (n >= length) {
            System.out.println(s);

        } else {
            int i = n;

            do {
                System.out.print(s.charAt(i % length));
                i += 1;
            } while (i % length != n);
        }
    }
}
