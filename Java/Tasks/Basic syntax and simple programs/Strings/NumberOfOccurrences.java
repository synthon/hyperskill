import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // naive approach, can be done with KMP
        // https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm
        Scanner sc = new Scanner(System.in);
        char[] data = sc.nextLine().toCharArray();
        char[] subst = sc.nextLine().toCharArray();
        int count = 0;

        for (int i = 0; i < data.length - subst.length + 1; i++) {
            int t = 0;

            for (int j = 0; j < subst.length; j++) {
                if (data[i + j] == subst[j]) {
                    t += 1;
                }
            }

            if (t == subst.length) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
