import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String... args) {
        File[] files = new File("PATH").listFiles();
        TreeMap<Integer, String> tm = new TreeMap<>();
        findEmptyDirs(files, tm, 0);
        System.out.println(tm.get(tm.lastKey()));
    }

    public static void findEmptyDirs(File[] files, TreeMap<Integer, String> tm, int level) {
        for (File file : files) {
            if (file.isDirectory()) {
                tm.put(level, file.getName());
                findEmptyDirs(file.listFiles(), tm, level + 1);
            } else {
                tm.put(level + 1, file.getName());
            }
        }
    }
}
