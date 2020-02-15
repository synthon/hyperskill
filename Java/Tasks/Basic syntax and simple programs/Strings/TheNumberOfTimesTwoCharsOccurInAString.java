import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        char chr1 = sc.next().charAt(0);
        char chr2 = sc.next().charAt(0);
        int count = 0;

        for (int i = 0; i < word.length - 1; i++) {
            if (word[i] == chr1 && word[i + 1] == chr2
                || word[i] == chr2 && word[i + 1] == chr1) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
