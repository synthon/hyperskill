import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : note) {
            if (!map.containsKey(word)) {
                System.out.println("You are busted");
                return;
            }
            map.put(word, map.get(word) - 1);
            if (map.get(word) == 0) {
                map.remove(word);
            }
        }
        System.out.println("You get money");
    }
}
