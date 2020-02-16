import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int count = 0;

        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == 'a' && str[i + 1] == 'b') {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
