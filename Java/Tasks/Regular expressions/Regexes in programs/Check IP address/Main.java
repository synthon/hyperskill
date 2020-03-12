import java.util.Scanner;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        String rx = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String regex = String.format("^%s\\.%s\\.%s\\.%s$", rx, rx, rx, rx);

        String input = sc.nextLine();
        boolean validIP = input.matches(regex);

        System.out.println(validIP ? "YES" : "NO");
    }
}
