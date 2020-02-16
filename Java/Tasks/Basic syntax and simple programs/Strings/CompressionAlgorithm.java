import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = (sc.nextLine() + '\u0000').split("");
        String prev = "";
        String out = "";
        int count = 0;

        for (String chr : seq) {
            if (chr.equals(prev)) {
                count += 1;

            } else {
                out += prev + (count < 1 ? "" : count);
                prev = chr;
                count = 1;
            }
        }

        System.out.println(out);
    }
}
