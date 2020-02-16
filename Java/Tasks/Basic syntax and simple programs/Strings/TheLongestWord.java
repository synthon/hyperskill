import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > words[index].length()) {
                index = i;
            }
        }

        System.out.println(words[index]);
    }
}
