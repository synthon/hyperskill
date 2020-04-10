import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.next());
        int y = Integer.parseInt(sc.next());
        List<List<Integer>> arr = new ArrayList<>();

        for (int a = 0; a < x; a++) {
            List<Integer> tmp = new ArrayList<>();

            for (int b = 0; b < y; b++) {
                tmp.add(Integer.parseInt(sc.next()));
            }

            arr.add(tmp);
        }

        int rot = sc.nextInt();
        Collections.rotate(arr, rot);

        for (List<Integer> k : arr) {
            k.forEach(e -> System.out.printf("%s ", e));
            System.out.println();
        }
    }
}
