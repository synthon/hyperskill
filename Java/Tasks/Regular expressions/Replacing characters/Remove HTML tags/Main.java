import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringWithHTMLTags = scanner.nextLine();

        String stringWithOutHTMLTags = stringWithHTMLTags.replaceAll("<[^>]*>", "");

        System.out.println(stringWithOutHTMLTags);
    }
}
