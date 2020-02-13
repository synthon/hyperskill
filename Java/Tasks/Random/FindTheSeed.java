import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeMap<Integer, Integer> seedMinMax = new TreeMap<>();

        for (int i = a; i < b + 1; i++) {
            Random generator = new Random(i);
            int seedMax = 0;

            for (int j = 0; j < n; j++) {
                int num = generator.nextInt(k);
                seedMax = Math.max(num, seedMax);
            }

            seedMinMax.put(seedMax, Math.min(seedMinMax.getOrDefault(seedMax, i), i));
        }

        System.out.println(seedMinMax.firstEntry().getValue());
        System.out.println(seedMinMax.firstEntry().getKey());
    }
}