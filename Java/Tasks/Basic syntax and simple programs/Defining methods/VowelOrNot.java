import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        return "aeuioAEUIO".indexOf(ch) != -1;
    }

    /* public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'A' || ch == 'E' || ch == 'U' || ch == 'I' || ch == 'O';
    } */

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
