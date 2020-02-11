import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfStudents = sc.nextInt();
        int a = 0, b = 0, c = 0, d = 0; // grades

        for (int i = 0, grade; i < numOfStudents; i++) {
            grade = sc.nextInt();
            if (grade == 5) a++;
            if (grade == 4) b++;
            if (grade == 3) c++;
            if (grade == 2) d++;
        }

        System.out.println(d + " " + c + " " + b + " " + a);
    }
}
