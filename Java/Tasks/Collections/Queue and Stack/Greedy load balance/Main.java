import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> queueOne = new ArrayDeque<>();
        ArrayDeque<String> queueTwo = new ArrayDeque<>();
        int queueOneLoad = 0;
        int queueTwoLoad = 0;

        for (int i = 0; i < lines; i++) {
            String[] task = sc.nextLine().split(" ");
            String taskNumber = task[0];
            int taskLoad = Integer.parseInt(task[1]);

            if (queueOneLoad <= queueTwoLoad) {
                queueOne.offer(taskNumber);
                queueOneLoad += taskLoad;
            } else {
                queueTwo.offer(taskNumber);
                queueTwoLoad += taskLoad;
            }
        }

        System.out.println(String.join(" ", queueOne));
        System.out.println(String.join(" ", queueTwo));
    }
}
