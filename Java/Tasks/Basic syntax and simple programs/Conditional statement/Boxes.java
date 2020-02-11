import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t;
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int z1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int z2 = sc.nextInt();

        if (x1 > y1) {
            t = x1;
            x1 = y1;
            y1 = t;
        }
        if (y1 > z1) {
            t = y1;
            y1 = z1;
            z1 = t;
        }
        if (x1 > y1) {
            t = x1;
            x1 = y1;
            y1 = t;
        }
        if (x2 > y2) {
            t = x2;
            x2 = y2;
            y2 = t;
        }
        if (y2 > z2) {
            t = y2;
            y2 = z2;
            z2 = t;
        }
        if (x2 > y2) {
            t = x2;
            x2 = y2;
            y2 = t;
        }

        if (x1 == x2 && y1 == y2 && z1 == z2) {
            System.out.println("Box 1 = Box 2");
        }
        else if (x1 <= x2 && y1 <= y2 && z1 <= z2) {
            System.out.println("Box 1 < Box 2");
        }
        else if (x1 >= x2 && y1 >= y2 && z1 >= z2) {
            System.out.println("Box 1 > Box 2");
        }
        else {
            System.out.println("Incomparable");
        }
    }
}
