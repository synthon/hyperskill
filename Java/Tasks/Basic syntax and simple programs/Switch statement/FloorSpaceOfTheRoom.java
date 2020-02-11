import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String figure = sc.nextLine();

        switch (figure) {
            case "triangle":
                double ta = sc.nextDouble();
                double tb = sc.nextDouble();
                double tc = sc.nextDouble();
                double p = (ta+tb+tc)/2;
                double areaOfTriangle = Math.sqrt(p*(p-ta)*(p-tb)*(p-tc));
                System.out.println(areaOfTriangle);
                break;
            case "rectangle":
                double ra = sc.nextDouble();
                double rb = sc.nextDouble();
                double areaOfRectangle = ra*rb;
                System.out.println(areaOfRectangle);
                break;
            case "circle":
                double r = sc.nextDouble();
                double areaOfCircle = 3.14*r*r;
                System.out.println(areaOfCircle);
                break;
        }
    }
}
