import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String... args) {
        File[] files = new File("PATH").listFiles();
        findEmptyDirs(files);
    }

    public static void findEmptyDirs(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();

                if (list.length == 0)
                    System.out.print(file.getName() + " ");

                findEmptyDirs(list);
            }
        }
    }
}
