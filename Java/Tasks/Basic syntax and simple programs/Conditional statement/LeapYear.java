import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year % 4 < 1 && year % 100 > 0 || year % 400 < 1) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }
    }
}
