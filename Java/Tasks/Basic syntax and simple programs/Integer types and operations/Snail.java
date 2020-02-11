import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextInt();
        double day = scanner.nextInt();
        double night = scanner.nextInt();

        double days = (height-night)/(day-night);

        System.out.println((int)Math.ceil(days));
    }
}
