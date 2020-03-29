package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {
    public static void main(final String... args) throws IOException {

        Scanner sc;
        String sortType = "natural";
        String dataType = "word";
        String inFileName = "";
        String outFileName = "";

        final Set<String> sortTypes = Set.of("natural", "bycount");
        final Set<String> dataTypes = Set.of("word", "long", "line");

        for (int i = 0; i < args.length; i++) {
            if ("-sortingType".equals(args[i])) {
                if (i + 1 >= args.length || !sortTypes.contains(args[i + 1].toLowerCase())) {
                    System.out.println("No sorting type defined!");
                    return;
                }
                sortType = args[++i];

            } else if ("-dataType".equals(args[i])) {
                if (i + 1 >= args.length || !dataTypes.contains(args[i + 1].toLowerCase())) {
                    System.out.println("No data type defined!");
                    return;
                }
                dataType = args[++i];

            } else if ("-inputFile".equals(args[i])) {
                inFileName = args[++i];

            } else if ("-outputFile".equals(args[i])) {
                outFileName = args[++i];

            } else {
                System.out.println("\"" + args[i] + "\" isn't a valid parameter. It's skipped.");
            }
        }

        if (inFileName.isEmpty()) {
            sc = new Scanner(System.in);
        } else {
            final File file = new File(inFileName);

            if (file.isFile()) {
                sc = new Scanner(file);
            } else {
                System.out.println("Error! File not found.");
                return;
            }
        }

        switch (dataType) {
            case "word":
                typeWord(sc, sortType, inFileName, outFileName);
                break;
            case "long":
                typeLong(sc, sortType, inFileName, outFileName);
                break;
            case "line":
                typeLine(sc, sortType, inFileName, outFileName);
                break;
        }
    }

    static void typeLong(final Scanner sc,
        final String sortType,
        final String inFileName,
        final String outFileName) throws FileNotFoundException {

        long total = 0;
        final SortedMap<Object, Integer> values = new TreeMap<>();
        boolean isNaturalSort = "natural".equals(sortType);

        try (sc) {
            while (sc.hasNext()) {
                final String token = sc.next();

                if (!token.matches("-?\\d+")) {
                    System.out.println("\"" + token + "\" isn't a long. It's skipped.");
                } else {
                    final long num = Long.valueOf(token);

                    values.put(num, values.getOrDefault(num, 0) + 1);
                    total += 1;
                }
            }
        }

        if (outFileName.isEmpty()) {
            print(values, total, "numbers", isNaturalSort);
        } else {
            toFile(outFileName, values, total, "numbers", isNaturalSort);
        }
    }

    static void typeLine(final Scanner sc,
        final String sortType,
        final String inFileName,
        final String outFileName) throws FileNotFoundException {

        long total = 0;
        final SortedMap<Object, Integer> values = new TreeMap<>();
        boolean isNaturalSort = "natural".equals(sortType);

        try (sc) {
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();

                values.put(line, values.getOrDefault(line, 0) + 1);
                total += 1;
            }
        }

        if (outFileName.isEmpty()) {
            print(values, total, "lines", isNaturalSort);
        } else {
            toFile(outFileName, values, total, "lines", isNaturalSort);
        }
    }

    static void typeWord(final Scanner sc,
        final String sortType,
        final String inFileName,
        final String outFileName) throws FileNotFoundException {

        long total = 0;
        final SortedMap<Object, Integer> values = new TreeMap<>();
        boolean isNaturalSort = "natural".equals(sortType);

        try (sc) {
            while (sc.hasNext()) {
                final String word = sc.next();

                values.put(word, values.getOrDefault(word, 0) + 1);
                total += 1;
            }
        }

        if (outFileName.isEmpty()) {
            print(values, total, "words", isNaturalSort);
        } else {
            toFile(outFileName, values, total, "words", isNaturalSort);
        }
    }

    static void toFile(final String outFileName,
        final SortedMap<Object, Integer> values,
        final long total,
        final String type,
        final boolean isNaturalSort) throws FileNotFoundException {

        final File file = new File(outFileName);
        final Stream<Entry<Object, Integer>> data = values.entrySet().stream().sorted(Map.Entry.comparingByValue());

        if (isNaturalSort) {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.printf("Total %s: %d.%n", type, total);

                if ("numbers".equals(type) || "words".equals(type)) {
                    printWriter.print("Sorted data: ");
                    for (final var entry : values.entrySet()) {
                        for (int i = 0; i < entry.getValue(); i++) {
                            printWriter.print(entry.getKey() + " ");
                        }
                    }

                } else {
                    printWriter.println("Sorted data:");
                    for (final var entry : values.entrySet()) {
                        for (int i = 0; i < entry.getValue(); i++) {
                            printWriter.println(entry.getKey());
                        }
                    }
                }
            }

        } else {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.printf("Total %s: %d.%n", type, total);

                data.forEach(entry -> printWriter.printf("%s: %d time(s), %d%%%n",
                                        entry.getKey(),
                                        entry.getValue(),
                                        Math.round(entry.getValue() * 100.0 / total)));
            }
        }
    }

    static void print(final SortedMap<Object, Integer> values,
        final long total,
        final String type,
        final boolean isNaturalSort) {

        final Stream<Entry<Object, Integer>> data = values.entrySet().stream().sorted(Map.Entry.comparingByValue());

        if (isNaturalSort) {
            System.out.printf("Total %s: %d.%n", type, total);
            if ("numbers".equals(type) || "words".equals(type)) {
                System.out.print("Sorted data: ");
                for (final var entry : values.entrySet()) {
                    for (int i = 0; i < entry.getValue(); i++) {
                        System.out.print(entry.getKey() + " ");
                    }
                }

            } else {
                System.out.println("Sorted data:");
                for (final var entry : values.entrySet()) {
                    for (int i = 0; i < entry.getValue(); i++) {
                        System.out.println(entry.getKey());
                    }
                }
            }

        } else {
            System.out.printf("Total %s: %d.%n", type, total);
            data.forEach(entry -> System.out.printf("%s: %d time(s), %d%%%n",
                                    entry.getKey(),
                                    entry.getValue(),
                                    Math.round(entry.getValue() * 100.0 / total)));
        }
    }
}
