import java.util.Scanner;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ticket = sc.nextLine().toCharArray();
        int magic = 0;

        for (int i = 0; i < 6; i++) {
            magic += i < 3 ? ticket[i] : -ticket[i];
        }

        System.out.println(magic == 0 ? "Lucky" : "Regular");
    }
}
