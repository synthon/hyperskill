import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> chSet = new HashMap<>();
        String wrdFirst = sc.nextLine().toUpperCase();
        String wrdSecond = sc.nextLine().toUpperCase();

        wrdFirst.chars().forEach(ch -> chSet.put(ch, chSet.getOrDefault(ch, 0) + 1));
        wrdSecond.chars().forEach(ch -> chSet.put(ch, chSet.getOrDefault(ch, 0) - 1));

        int delete = chSet.values().stream().reduce(0, (a, b) -> Math.abs(a) + Math.abs(b));

        System.out.println(delete);
    }
}
