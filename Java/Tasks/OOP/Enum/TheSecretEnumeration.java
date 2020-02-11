public class Main {

    public static void main(String[] args) {
        int stars = 0;
        for (Secret val : Secret.values()) {
            if (val.name().startsWith("STAR")) {
                stars++;
            }
        }
        System.out.println(stars);
    }
}

/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}
*/
