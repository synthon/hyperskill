import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] date = sc.nextLine().split("-");

        if (date.length != 3 || Integer.parseInt(date[0]) < 1
            || Integer.parseInt(date[1]) < 1 || Integer.parseInt(date[2]) < 1
            || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31) {

            System.out.println("Incorrect input");
            return;
        }

        System.out.println(date[1] + "/" + date[2] + "/" + date[0]);
    }
}
