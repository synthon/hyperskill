import java.util.*;

public class Main {

    public static int convert(Double val) {
        return val.isNaN() ? 0
             : val == Double.POSITIVE_INFINITY ? Integer.MAX_VALUE
             : val == Double.NEGATIVE_INFINITY ? Integer.MIN_VALUE
             : (int) (double) val;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}
