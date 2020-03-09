import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Complex {
    double real;
    double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real,
                           a.imag + b.imag);
    }

    public static Complex divide(Complex a, Complex b) {
        Complex bConjugate = b.conjugate();
        Complex a1 = Complex.multiply(a, bConjugate);
        Complex b1 = Complex.multiply(b, bConjugate);

        return new Complex(a1.real / b1.real,
                           a1.imag / b1.real);
    }

    public static Complex multiply(Complex a, Complex b) {
        return new Complex(a.real * b.real - a.imag * b.imag,
                           a.real * b.imag + a.imag * b.real);
    }

    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    public static Complex make(String num) {
        String[] ri = num.split("^|(?=[+-]\\d*i)");
        Complex number = new Complex(0, 0);

        if (ri.length == 1) {
            ri[0] = ri[0].replace("+", "");

            if (ri[0].equals("i")) {
                return new Complex(0, 1);
            }

            if (ri[0].equals("-i")) {
                return new Complex(0, -1);
            }

            if (ri[0].endsWith("i")) {
                return new Complex(0, Double.parseDouble(ri[0].substring(0, ri[0].length() - 1)));
            }

            return new Complex(Double.parseDouble(ri[0]), 0);
        }

        ri[1] = ri[1].replace("+","");
        if (ri[1].equals("i")) {
            number.imag = 1;
        } else if (ri[1].equals("-i")) {
            number.imag = -1;
        } else if (ri[1].endsWith("i")) {
            number.imag = Double.parseDouble(ri[1].substring(0, ri[1].length() - 1));
        }

        number.real = Double.parseDouble(ri[0]);

        return number;
    }

    @Override
    public String toString() {
        final double EPSILON = 0.001;
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        final DecimalFormat realFormat = new DecimalFormat("0.####", symbols);
        final DecimalFormat imagFormat = new DecimalFormat("0.####i", symbols);

        if (Math.abs(imag) < EPSILON) {
            return realFormat.format(real);
        }

        if (Math.abs(real) < EPSILON) {
            return imagFormat.format(imag);
        }

        imagFormat.setPositivePrefix("+");
        return String.format("%s%s", realFormat.format(real), imagFormat.format(imag));
    }
}
