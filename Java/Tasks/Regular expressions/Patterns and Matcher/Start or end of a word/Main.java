import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern regex = Pattern.compile("(?i)" + part + "\\b|\\b" + part);
        Matcher match = regex.matcher(line);

        boolean isSubstr = match.find();
        String ans = isSubstr ? "YES" : "NO";

        System.out.println(ans);
    }
}
