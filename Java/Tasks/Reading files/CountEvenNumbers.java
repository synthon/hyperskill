import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset_91065.txt");
        int countEven = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                int next = sc.nextInt();
                if (next == 0) {
                     break;
                 } 
                countEven += next % 2 == 0 ? 1 : 0;
            }
        }

        System.out.println(countEven);
    }
}