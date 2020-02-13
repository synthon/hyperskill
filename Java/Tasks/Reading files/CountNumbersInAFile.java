import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset_91022.txt");
        int count = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                count += sc.nextInt() >= 9999 ? 1 : 0;
            }
        }

        System.out.println(count);
    }
}