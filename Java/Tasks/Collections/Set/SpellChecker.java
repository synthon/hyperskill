import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(sc.nextLine());
        Set<String> dictionary = new HashSet<>();

        for (int i = 0; i < numberOfWords; i++) {
            dictionary.add(sc.nextLine().toLowerCase());    
        }

        int numberOfLines = Integer.parseInt(sc.nextLine());
        Set<String> erroneous = new LinkedHashSet<>();

        for (int i = 0; i < numberOfLines; i++) {
            for (String word : sc.nextLine().split(" ")) {
                if (!dictionary.contains(word.toLowerCase())) {
                    erroneous.add(word.toLowerCase());
                }
            }
        }

        erroneous.forEach(System.out::println);
    }
}
