import java.util.Scanner;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger c = new BigInteger(sc.next());
        BigInteger d = new BigInteger(sc.next());

        BigInteger perform = a.negate().multiply(b).add(c).subtract(d);
        System.out.println(perform);
    }
}
