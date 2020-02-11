import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boy1 = sc.nextInt();
        int boy2 = sc.nextInt();
        int boy3 = sc.nextInt();
        
        boolean asc = boy1 <= boy2 && boy2 <= boy3;
        boolean desc = boy1 >= boy2 && boy2 >= boy3;

        System.out.println(asc || desc);
    }
}
