import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String... args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {

            boolean isPotentialWord = false;
            int lastChar = reader.read();
            int totalWords = 0;

            while (lastChar != -1) {
                isPotentialWord = lastChar != ' ';
                lastChar = reader.read();

                if ((lastChar == -1 || lastChar == ' ') && isPotentialWord) {
                    totalWords += 1;
                }
            }

            System.out.println(totalWords);
        }
    }
}
