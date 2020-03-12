import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        boolean validPlate = regNum.matches("^[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}$");

        System.out.println(validPlate);
    }
}
