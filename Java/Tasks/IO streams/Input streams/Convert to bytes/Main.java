import java.io.InputStream;

class Main {
    public static void main(String... args) throws Exception {
        InputStream inputStream = System.in;

        for (int b : inputStream.readAllBytes()) {
            System.out.print(b);
        }
    }
}
