import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> arr = new ArrayList<>(List.of(array));
        ListIterator<String> iter = arr.listIterator();

        while (iter.hasNext()) {
            String curr = iter.next();

            if (curr.charAt(0) == 'J') {
                iter.set(curr.substring(1, curr.length()));
            } else {
                iter.remove();
            }
        }

        Collections.reverse(arr);

        arr.forEach(System.out::println);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}
