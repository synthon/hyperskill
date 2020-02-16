import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kval = sc.nextLine().split("\\?")[1].split("&");
        String passValue = "";

        for (String kv : kval) {
            String[] vars = kv.split("=");

            if (vars.length < 2) {
                System.out.printf("%s : not found%n", vars[0]);
            } else {
                System.out.printf("%s : %s%n", vars[0], vars[1]);
            }
            if ("pass".equals(vars[0])) {
                passValue = vars[1];
            }
        }

        if (!"".equals(passValue)) {
            System.out.println("password : " + passValue);
        }
    }
}
