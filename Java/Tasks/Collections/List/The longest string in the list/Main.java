import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        int ind = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > list.get(ind).length()) {
                ind = i;
            }
        }

        String word = list.get(ind);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, word);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}
