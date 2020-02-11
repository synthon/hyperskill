import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int food = scanner.nextInt();
        int flight = scanner.nextInt();
        int night = scanner.nextInt();

        System.out.println(day*food+2*flight+(day-1)*night);
    }
}
