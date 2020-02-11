import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfCompanies = sc.nextInt();
        int[] income = new int[numberOfCompanies];
        double maxTax = 0;
        int comp = 1;
        double tax;

        for (int i = 0; i < numberOfCompanies; i++) {
            income[i] = sc.nextInt();
        }

        for (int i = 0; i < numberOfCompanies; i++) {
            tax = income[i] / 100.0 * sc.nextInt();
            if (tax > maxTax) {
                comp = i + 1;
                maxTax = tax;
            }
        }

        System.out.println(comp);
    }
}
