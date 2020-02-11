import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> table = new TreeMap<>();

        Arrays.asList(strings).forEach(word -> table.put(word, table.getOrDefault(word, 0) + 1));

        return table;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((word, freq) -> System.out.println(word + " : " + freq));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}
