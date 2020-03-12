import java.util.Scanner;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String regex = "(?=.*[A-Z])(?=.*\\d)(?=.*[a-z]).{12,}";
        boolean isSafePassword = input.matches(regex);

        System.out.println(isSafePassword ? "YES" : "NO");
    }
}
