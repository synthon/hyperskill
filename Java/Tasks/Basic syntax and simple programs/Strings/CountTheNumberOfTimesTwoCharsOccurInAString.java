import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        char[] subst = (data[1] + data[2]).substring(0, 2).toCharArray();
        int count = 0;

        for (int i = 1; i < data[0].length(); i++) {
            if (subst[1] == data[0].charAt(i)
                && subst[0] == data[0].charAt(i - 1)) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
