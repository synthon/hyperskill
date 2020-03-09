package solver;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        String from = "";
        String to = "";

        for (int i = 0; i < args.length; i += 2) {
            if ("-in".equals(args[i])) {
                from = args[i + 1];
            } else {
                to = args[i + 1];
            }
        }

        // there is probably a design patter for that, but...
        toFile(rref(fromFile(from)), to);
    }


    /**
     * Returns an augmented matrix from fileName as Complex[][]
     * Can be both complex and not complex numbers
     *
     * Example:
     *  3 3
     *  1+2i -1.5-1.1i 2.12 91+5i
     *  -1+3i 1.2+3.5i -3.3 1+15i
     *  12.31 1.3-5i 12.3i -78.3i
     *
     *  Where first value is a number of variables,
     *  second is a number of equations
     *
     * @param  fileName read data from file if exists
     * @return          augmented matrix
     */
    static Complex[][] fromFile(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        String[] initValues = sc.nextLine().split(" ");
        int initColumns = Integer.parseInt(initValues[0]);
        int initRows = Integer.parseInt(initValues[1]);
        Complex[][] augmentedMatrix = new Complex[initRows][initColumns + 1];

        // fill the augmented matrix
        for (int i = 0; i < initRows; i++) {
            for (int j = 0; j < initColumns + 1; j++) {
                augmentedMatrix[i][j] = Complex.make(sc.next());
            }
        }
        sc.close();

        return augmentedMatrix;
    }


    /**
     * Returns a solution if exists or appropriate message
     * Saves to the file
     *
     * @param augmentedMatrix rref matrix
     * @param fileName        write data to file
     */
    static void toFile(Complex[][] augmentedMatrix, String fileName) throws IOException {
        File file = new File(fileName);
        int matrixLength = augmentedMatrix.length;
        boolean inf = false;
        boolean nosol = false;

        // check if no solutions
        for (Complex[] k : augmentedMatrix) {
            int cnt = 0;
            for (Complex v : k) {
                if (v.real == 0 && v.imag == 0) {
                    cnt += 1;
                }
            }
            if (cnt == k.length) {
                matrixLength -= 1;
            }

            if (!(k[k.length - 1].real == 0 &&
                    k[k.length - 1].imag == 0)
                    && cnt == k.length - 1) {

                nosol = true;
                break;
            }
        }

        // check if more than one solution
        if (augmentedMatrix.length - matrixLength > 1 ||
                matrixLength < augmentedMatrix[0].length - 1) {
            inf = true;
        }

        // write solution to the file
        String[] tmp = new String[matrixLength];
        try (PrintWriter printWriter = new PrintWriter(file)) {
            if (nosol) {
                System.out.println("No solutions");
                printWriter.println("No solutions");
            } else if (inf) {
                System.out.println("Infinitely many solutions");
                printWriter.println("Infinitely many solutions");
            } else {
                for (int i = 0; i < matrixLength; i++) {
                    printWriter.println(augmentedMatrix[i][augmentedMatrix[0].length - 1]);
                    tmp[i] = (augmentedMatrix[i][augmentedMatrix[0].length - 1]).toString();
                }
                System.out.println("The solution is: (" + String.join(", ", tmp) + ")");
            }
        }

        System.out.println("Saved to file " + fileName);
    }


    /**
     * Performing rref on a given augmentedMatrix
     * @see <a href="https://en.wikipedia.org/wiki/Row_echelon_form">RREF</a>
     *
     * @param augmentedMatrix matrix
     * @return                augmentedMatrix in rref form
     */
    static Complex[][] rref(Complex[][] augmentedMatrix) {
        System.out.println("Start solving the equation.");
        int rows = augmentedMatrix.length;
        int columns = augmentedMatrix[0].length;
        Complex multiplier;

        int pivot = 0;
        for (int c = 0; c < columns - 1; c++) {
            int r = pivot;
            int row = r;

            while (row < rows - 1 &&
                    (augmentedMatrix[row][c].real == 0 &&
                            augmentedMatrix[row][c].imag == 0)) {
                row += 1;
            }

            if (!(augmentedMatrix[row][c].real == 0 &&
                    augmentedMatrix[row][c].imag == 0)) {
                pivot += 1;

                if (r != row) {
                    Complex[] aux = augmentedMatrix[r];
                    augmentedMatrix[r] = augmentedMatrix[row];
                    augmentedMatrix[row] = aux;
                    System.out.printf("R%d <-> R%d%n", r, row);
                }

                multiplier = augmentedMatrix[r][c];
                if (!multiplier.toString().equals("1") &&
                        !multiplier.toString().equals("0") &&
                        !multiplier.toString().equals("-0")) {

                    System.out.printf("R%d / %s  -> R%d%n", r + 1, multiplier.toString(), r + 1);
                    for (int q = 0; q < columns; q++) {
                        augmentedMatrix[r][q] = Complex.divide(augmentedMatrix[r][q], multiplier);
                    }
                }

                for (int z = r + 1; z < rows; z++) {
                    multiplier = Complex.multiply(new Complex(-1, 0), augmentedMatrix[z][c]);
                    if (!multiplier.toString().equals("1") &&
                            !multiplier.toString().equals("0") &&
                            !multiplier.toString().equals("-0")) {

                        System.out.printf("%s * R%d + R%d -> R%d%n", multiplier.toString(), r + 1, z + 1, z + 1);

                        for (int k = 0; k < columns; k++) {
                            augmentedMatrix[z][k] = Complex.add(augmentedMatrix[z][k], Complex.multiply(augmentedMatrix[r][k], multiplier));
                        }
                    }
                }
            }
        }

        for (int i = rows - 2; i > -1; i--) {
            for (int j = i; j > -1; j--) {
                if (augmentedMatrix[j][i + 1].real == 0 &&
                        augmentedMatrix[j][i + 1].imag == 0) {
                    continue;
                }

                multiplier = Complex.multiply(new Complex(-1, 0), augmentedMatrix[j][i + 1]);
                System.out.printf("%s * R%d + R%d -> R%d%n", multiplier.toString(), i + 2, j + 1, j + 1);

                for (int k = 0; k < columns; k++) {
                    augmentedMatrix[j][k] = Complex.add(augmentedMatrix[j][k], Complex.multiply(augmentedMatrix[i + 1][k], multiplier));

                }
            }
        }

        return augmentedMatrix;
    }
}
