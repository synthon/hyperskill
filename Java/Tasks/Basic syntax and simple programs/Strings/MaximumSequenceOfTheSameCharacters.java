import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        int longest = 0;
        int curr = 0;
        String prev = "";

        for (String s : str) {
            if (s.equals(prev)) {
                curr += 1;
            } else {
                prev = s;
                curr = 1;
            }
            longest = Math.max(longest, curr);
        }

        System.out.println(prev.isEmpty() ? 0 : longest);
    }
}
