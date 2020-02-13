import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset_91007.txt");
        int max = Integer.MIN_VALUE;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                max = Math.max(sc.nextInt(), max);
            }
        }

        System.out.println(max);
    }
}