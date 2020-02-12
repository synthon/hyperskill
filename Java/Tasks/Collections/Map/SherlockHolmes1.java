import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word1 = sc.nextLine().toLowerCase().split("");
        String[] word2 = sc.nextLine().toLowerCase().split("");
        Map<String, Integer> map = new HashMap<>();

        for (String k : word1) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        for (String k : word2) {
            map.put(k, map.getOrDefault(k, 0) - 1);
        }

        for (int v : map.values()) {
            if (v != 0) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
