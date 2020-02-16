import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] words = sc.nextLine().toLowerCase().toCharArray();
        int index = -1;

        for (int i = 2; i < words.length; i++) {
            if (words[i - 2] == 't' && words[i - 1] == 'h' && words[i] == 'e') {
                index = i - 2;
                break;
            }
        }

        System.out.println(index);
    }
}
