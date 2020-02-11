import java.util.*;

class MapUtils {

    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map) {
        int firstKey = map.firstEntry().getKey();
        int lastKey = map.lastEntry().getKey();

        if (firstKey % 2 != 0) {
            return map.subMap(firstKey, true, 4 + firstKey, true).descendingMap();
        }
        
        return map.subMap(lastKey - 4, true, lastKey, true).descendingMap();
    }

}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]),pair[1]);
        });
        NavigableMap<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
