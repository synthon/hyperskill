import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int shift = sc.nextInt();

        String[] out = new String[seq.length];
        for (int i = 0; i < seq.length; i++) {
            out[(i + shift) % seq.length] = seq[i];
        }

        System.out.println(String.join(" ", out));
    }
}
