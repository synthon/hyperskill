import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[+-]?(?:0|[1-9][0-9]+)(?:[.,](?:0|[0-9]*[1-9]+))?$";

        String time = scanner.nextLine();
        System.out.println(time.matches(regex) ? "YES" : "NO");
    }
}
