import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        String _regex = String.format("(?i)\\b[a-z]{%d}\\b", size);
        Pattern regex = Pattern.compile(_regex);
        Matcher match = regex.matcher(line);

        boolean isSizeN = match.find();
        String ans = isSizeN ? "YES" : "NO";

        System.out.println(ans);
    }
}
