import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Character> list = new ArrayList<>();
            int bs = reader.read();

            while (bs != -1) {
                list.add((char) bs);
                bs = reader.read();
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i));
            }
        }
    }
}
