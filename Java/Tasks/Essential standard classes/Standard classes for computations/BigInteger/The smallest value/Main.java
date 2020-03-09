import java.util.Scanner;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = 0L;
        BigInteger big = BigInteger.ONE;
        BigInteger given = sc.nextBigInteger();

        while (big.compareTo(given) < 0) {
            big = big.multiply(BigInteger.valueOf(++n));
        }

        System.out.println(n);
    }
}
