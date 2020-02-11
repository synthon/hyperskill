import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            try {
                int k = Integer.parseInt(input);

                if (k == 0) {
                    return;
                }

                System.out.println(k * 10);

            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}
