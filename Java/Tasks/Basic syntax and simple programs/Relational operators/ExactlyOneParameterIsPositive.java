import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        
        boolean c1 = n1 > 0 && n2 < 1 && n3 < 1;
        boolean c2 = n1 < 1 && n2 > 0 && n3 < 1;
        boolean c3 = n1 < 1 && n2 < 1 && n3 > 0;
        
        System.out.println(c1 || c2 || c3);
    }
}
