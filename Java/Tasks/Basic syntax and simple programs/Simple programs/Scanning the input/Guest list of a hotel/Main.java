import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> out = new ArrayList<>();

        while (sc.hasNext()) {
            out.add(sc.next());
        }

        for (int i = out.size() - 1; i > -1; i--) {
            System.out.println(out.get(i));
        }
    }
}
