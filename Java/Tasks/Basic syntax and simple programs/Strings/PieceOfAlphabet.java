import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        Boolean substr = true;

        for (int i = 1; i < str.length; i++) {
            if (str[i] - str[i - 1] != 1) {
                substr ^= true;
                break;
            }
        }

        System.out.println(substr);
    }
}
