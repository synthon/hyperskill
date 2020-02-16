import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int count = 0;

        for (char i : data[0].toCharArray()) {
            if (i == data[1].charAt(0)) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
