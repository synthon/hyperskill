import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(), square;

        for (int i = 1; ; i++) {

            square = i*i;

            if (square > num) break;
            System.out.println(square);
        }

    }
}
