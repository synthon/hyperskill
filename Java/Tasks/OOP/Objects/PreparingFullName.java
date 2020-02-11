import java.util.Scanner;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {
        Boolean isFirstName = firstName != null;
        Boolean isLastName = lastName != null;

        String fullName = (isFirstName ? firstName : "")
                        + (isFirstName && isLastName ? " " : "")
                        + (isLastName ? lastName : "");
        return fullName;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}
