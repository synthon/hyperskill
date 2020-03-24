import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            int size = sc.nextInt();

            for (int j = 0; j < size; j++) {
                arr.add(sc.nextInt());
            }
        }

        for (int k : mergeSort(arr)) {
            System.out.print(k + " ");
        }
    }

    public static List<Integer> mergeSort(List<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }

        int middle = array.size() / 2;

        List<Integer> right = mergeSort(array.subList(0, middle));
        List<Integer> left = mergeSort(array.subList(middle, array.size()));

        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterLeft = left.iterator();
        Iterator<Integer> iterRight = right.iterator();

        Integer x = iterLeft.next();
        Integer y = iterRight.next();

        while (true) {
            if (x.compareTo(y) >= 0) {
                result.add(x);

                if (iterLeft.hasNext()) {
                    x = iterLeft.next();

                } else {
                    result.add(y);

                    while (iterRight.hasNext()) {
                        result.add(iterRight.next());
                    }

                    break;
                }
            } else {
                result.add(y);
                if (iterRight.hasNext()) {
                    y = iterRight.next();

                } else {
                    result.add(x);

                    while (iterLeft.hasNext()) {
                        result.add(iterLeft.next());
                    }

                    break;
                }
            }
        }

        return result;
    }
}
