import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavigableMap<Integer, String> map = new TreeMap<>();

        int start = sc.nextInt();
        int end = sc.nextInt();
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            map.put(sc.nextInt(), sc.next());
        }

        map.subMap(start, true, end, true).forEach((key, value) -> System.out.println(key + " " + value));
    }
}
