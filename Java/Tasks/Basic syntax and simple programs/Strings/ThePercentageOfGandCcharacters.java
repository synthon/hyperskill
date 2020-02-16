import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] seq = sc.nextLine().toLowerCase().toCharArray();
        int count = 0;

        for (char chr : seq) {
            if (chr == 'c' || chr == 'g') {
                count += 1;
            }
        }

        System.out.println(100.0 * count / seq.length);
    }
}
