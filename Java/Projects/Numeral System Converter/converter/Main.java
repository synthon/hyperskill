package converter;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(final String... args) {
        final Scanner sc = new Scanner(System.in);
        ArrayList<String> in = new ArrayList<>();

        while (sc.hasNext()) {
            in.add(sc.next());
        }
        sc.close();

        if (in.size() != 3) {
            System.out.println("ERROR! Example: 21 4243 6. " +
                "Where 4243 is the number, 21 is the initial base and 6 is the desired base.");
            return;
        }

        final String fromRadix = in.get(0);
        final String num = in.get(1);
        final String toRadix = in.get(2);

        if (!BaseConverter.errorCheck(num, fromRadix, toRadix)) {
            final BaseConverter number = new BaseConverter(num);
            number.convert(fromRadix, toRadix);
            number.print();
        }
    }
}

class BaseConverter {
    final int CUT_AFTER = 5;
    String wholeNumber;
    String fractions;

    BaseConverter(final String number) {
        final String[] num = number.split("\\.");

        if (num.length == 1) {
            wholeNumber = num[0];
        } else {
            wholeNumber = num[0];
            fractions = num[1];
        }
    }

    private void toBase10(final int radix) {
        wholeNumber = String.valueOf(
            radix != 1
                ? Long.parseLong(wholeNumber, radix)
                : wholeNumber.length()
        );

        if (fractions != null) {
            double tmpFracValue = 0.0;

            for (int i = 0; i < fractions.length(); i++) {
                tmpFracValue += (
                    Long.parseLong(
                        String.valueOf(fractions.charAt(i)),
                        radix
                    ) / Math.pow(radix, i + 1)
                );
            }

            fractions = String.valueOf(tmpFracValue);
        }
    }

    private void toGivenBase(final int radix) {
        wholeNumber = radix != 1
            ? String.valueOf(
            Long.toString(
                Long.valueOf(wholeNumber),
                radix
            )
        )
            : "1".repeat(Integer.valueOf(wholeNumber));

        if (fractions != null) {
            Double tmpFrac = Double.valueOf(fractions);
            fractions = "";

            for (int i = 0; i < CUT_AFTER; i++) {
                tmpFrac *= radix;
                fractions += Long.toString(tmpFrac.longValue(), radix);
                tmpFrac %= 1;
            }
        }

        if (radix == 1) { fractions = null; }
    }

    void convert(final String from, final String to) {
        toBase10(Integer.valueOf(from));
        toGivenBase(Integer.valueOf(to));
    }

    @Override
    public String toString() {
        return wholeNumber + (fractions != null ? "." + fractions : "");
    }

    void print() {
        System.out.println(toString());
    }

    static boolean errorCheck(String number, String fromRadix, String toRadix) {
        boolean isError = false;
        String errmsg = "Error!";

        if (number.split("\\.").length > 2 || number.split("\\.").length == 0 ||
            number == null ||
            number.isEmpty() ||
            number.replaceAll("[a-zA-Z\\d.]+", "").length() > 0) {

            errmsg += " \"" + number + "\" - is not a correct number!";

            isError = true;
        }

        if (fromRadix.isEmpty() ||
            fromRadix == null ||
            !fromRadix.matches("^[1-9]$|^[12][0-9]$|^3[0-6]$")) {

            errmsg += " Initial base \"" + fromRadix +
                "\" for the number is wrong! Try any integer from 1 to 36.";

            isError = true;
        }

        if (toRadix.isEmpty() ||
            toRadix == null ||
            !toRadix.matches("^[1-9]$|^[12][0-9]$|^3[0-6]$")) {

            errmsg += " Desired base \"" + toRadix +
                "\" for the number is wrong! Try any integer from 1 to 36.";

            isError = true;
        }

        if (isError) System.out.println(errmsg);
        return isError;
    }
}
