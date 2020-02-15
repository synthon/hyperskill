import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generate = new Random();
        String password = "";

        int upper = sc.nextInt();
        int lower = sc.nextInt();
        int digits = sc.nextInt();
        int symbols = sc.nextInt();
        int other = symbols - digits - lower - upper;
        int prev = 0;

        while (password.length() != symbols) {
            int[] woof = {generate.nextInt(26) + 65, // upper case letters
                          generate.nextInt(26) + 97, // lower case letters
                          generate.nextInt(10) + 48, // numbers
                          generate.nextInt(94) + 33}; // mix
            int pick = generate.nextInt(9999) % 4;
            int curr = woof[pick];

            if (curr != prev) {
                if (upper > 0 && pick == 0) {
                    password += (char) curr;
                    upper -= 1;
                    prev = curr;

                } else if (lower > 0 && pick == 1) {
                    password += (char) curr;
                    lower -= 1;
                    prev = curr;

                } else if (digits > 0 && pick == 2) {
                    password += (char) curr;
                    digits -= 1;
                    prev = curr;

                } else if (other > 0) {
                    password += (char) curr;
                    other -= 1;
                    prev = curr;
                }
            }
        }

        System.out.println(password);
    }
}
