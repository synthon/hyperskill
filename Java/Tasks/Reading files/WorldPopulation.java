import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset_91069.txt");
        int year = -1;

        try (Scanner sc = new Scanner(file)) {
            long gain = -1;
            long prevPpl = -1;

            while (sc.hasNext()) {
                String[] data = sc.nextLine().split("\\s");

                try {
                    int currYear = Integer.parseInt(data[0]);
                    long currPpl = Long.parseLong(data[1].replaceAll(",", ""));

                    if (year < 0) {
                        year = currYear;
                        prevPpl = currPpl;
                    } else {
                        if (currPpl - prevPpl > gain) {
                            year = currYear;
                            gain = currPpl - prevPpl;
                        }
                    }
                    prevPpl = currPpl;

                } catch (Exception exception) {}
            }
        }

        System.out.println(year);
    }
}
