import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        String[] seq = sc.nextLine().split(" ");
        String nm = sc.nextLine();

        for (int i = 1; i < seq.length; i++) {
            if ((seq[i] + " " + seq[i-1]).equals(nm) ||
                (seq[i-1] + " " + seq[i]).equals(nm)) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
