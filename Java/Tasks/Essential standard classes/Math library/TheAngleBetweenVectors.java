import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double v1 = sc.nextDouble();
        double v2 = sc.nextDouble();
        double u1 = sc.nextDouble();
        double u2 = sc.nextDouble();

        double dot = u1 * v1 + u2 * v2;
        double vLength = Math.sqrt(v1 * v1 + v2 * v2);
        double uLength = Math.sqrt(u1 * u1 + u2 * u2);
        double angle = Math.toDegrees(Math.acos(dot / (vLength * uLength)));

        System.out.println(angle);
    }
}
