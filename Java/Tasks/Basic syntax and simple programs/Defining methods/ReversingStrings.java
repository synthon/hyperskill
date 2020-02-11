import java.util.*;

public class Main {

    public static String[] reverse(String... words) {
        int len = words.length;

        for (int i = 0; i < len/2; i++) {
            String temp = words[len+~i];
            words[len+~i] = words[i];
            words[i] = temp;
        }

        return words;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        String[] reversed = reverse(words);
        Arrays.stream(reversed).forEach(e -> System.out.print(e + " "));
    }
}
