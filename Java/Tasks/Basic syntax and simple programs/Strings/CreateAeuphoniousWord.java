import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        int count = 0;
        int need = 0;
        Boolean inVow = true;
        String vow = "eyuioa";

        for (String s : str) {
            if (inVow == vow.indexOf(s) > -1) {
                count += 1;

            } else {
                inVow ^= true;
                need += (count - 1) / 2;
                count = 1;
            }
        }

        System.out.println(need + (count - 1) / 2);
    }
}
