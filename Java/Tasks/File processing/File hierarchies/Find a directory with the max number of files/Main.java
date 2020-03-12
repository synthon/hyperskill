import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String... args) {
        File[] files = new File("PATH").listFiles();
        TreeMap<Integer, String> tm = new TreeMap<>();
        findEmptyDirs(files, tm);

        System.out.println(tm.get(tm.lastKey()) + " " + tm.lastKey());
    }

    public static void findEmptyDirs(File[] files, TreeMap<Integer, String> tm) {
        for (File file : files) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                tm.put(list.length, file.getName());
                findEmptyDirs(list, tm);
            }
        }
    }
}
