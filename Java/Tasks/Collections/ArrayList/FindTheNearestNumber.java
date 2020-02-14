import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> listClosest = new ArrayList<>();
        int distance = Integer.MAX_VALUE;

        String[] input = sc.nextLine().split(" ");
        int num = sc.nextInt();

        for (String curr : input) {
            int tmp = Integer.parseInt(curr);
            int currDist = Math.abs(tmp - num);

            if (currDist < distance) {
                distance = currDist;
                listClosest.clear();
                listClosest.add(tmp);

            } else if (currDist == distance) {
                listClosest.add(tmp);
            }
        }

        Collections.sort(listClosest);

        for (int n : listClosest) {
            System.out.print(n + " ");
        }
    }
}
