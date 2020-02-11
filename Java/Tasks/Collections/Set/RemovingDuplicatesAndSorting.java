import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(sc.nextLine());

        SortedSet<String> set = new TreeSet<>();

        for (int i = 0; i < numberOfElements; i++) {
            set.add(sc.nextLine());
        }

        set.forEach(System.out::println);
    }
}
