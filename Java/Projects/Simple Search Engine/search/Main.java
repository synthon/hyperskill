package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String... args) throws FileNotFoundException {

        if (args.length == 2) {
            if ("--data".equals(args[0])) {
                Search search = new Search();
                search.search(args[1]);
            }
        }

    }
}

class Search {
    ArrayList<String> data = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> invIndex = new HashMap<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void search(String inFileName) throws FileNotFoundException {
        File file = new File(inFileName);

        if (file.isFile()) {
            try (Scanner sc = new Scanner(file)) {
                int l = 0;

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();

                    data.add(line);

                    for (String str : line.split("\\s+")) {
                        str = str.toLowerCase();

                        if (invIndex.containsKey(str)) {
                            invIndex.get(str).add(l);
                        } else {
                            invIndex.put(str, new ArrayList<>(List.of(l)));
                        }
                    }

                    hm.put(l, 0);
                    l += 1;
                }
            }

        } else {
            System.out.println("Error! File not found.");
            return;
        }

        menu();
    }

    void find() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        String strategy = sc.nextLine();

        System.out.println("\nEnter a name or email to search all suitable people.");
        HashSet<String> query = new HashSet<>(Set.of(sc.nextLine().toLowerCase().split("\\s+")));
        HashSet<Integer> found = new HashSet<>();

        for (String q : query) {
            if (invIndex.containsKey(q)) {
                for (int ind : invIndex.get(q)) {
                    hm.put(ind, hm.get(ind) + 1);
                }
            }
        }

        switch (strategy) {
            case "ALL":
                for (var kv : hm.entrySet()) {
                    if (kv.getValue() == query.size()) {
                        found.add(kv.getKey());
                    }
                }
                break;

            case "ANY":
                for (var kv : hm.entrySet()) {
                    if (kv.getValue() > 0) {
                        found.add(kv.getKey());
                    }
                }
                break;

            case "NONE":
                for (var kv : hm.entrySet()) {
                    if (kv.getValue() == 0) {
                        found.add(kv.getKey());
                    }
                }
                break;
        }

        if (found.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println();
            System.out.println(found.size() + " persons found:");
            for (Integer p : found) {
                System.out.println(data.get(p));
            }
        }

        System.out.println();
    }

    void print() {
        System.out.println("\n=== List of people ===");

        data.forEach(System.out::println);

        System.out.println();
    }

    void menu() {
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            String key = sc.nextLine();

            switch (key) {
                case "1":
                    find();
                    break;
                case "2":
                    print();
                    break;
                case "0":
                    exit();
                    return;
                default:
                    System.out.println("\nIncorrect option! Try again.\n");
                    break;
            }
        }
    }

    void exit() {
        System.out.println("\nBye!");
    }
}
