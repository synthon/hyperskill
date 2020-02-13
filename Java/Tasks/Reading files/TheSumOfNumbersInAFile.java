import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset_91033.txt");
        long sum = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                sum += sc.nextInt();
            }
        }

        System.out.println(sum);
    }
}