import java.util.Scanner;
import java.util.regex.*;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        boolean isFound = false;

        Pattern pattern = Pattern.compile("(?i)password.*?([0-9a-z]+)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            isFound = true;
            System.out.println(matcher.group(1));
        }

        if (!isFound) {
            System.out.println("No passwords found.");
        }
    }
}
