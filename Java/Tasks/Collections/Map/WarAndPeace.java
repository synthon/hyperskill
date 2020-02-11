import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().toLowerCase().split(" ");
        Map<String, Integer> dict = new HashMap<>();

        Arrays.asList(words).forEach(word -> dict.put(word, dict.getOrDefault(word, 0) + 1));
        dict.forEach((word, freq) -> System.out.println(word + " " + freq));
    }
}
