package flashcards;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws IOException {
        final ArrayList<String> logTrace = new ArrayList<>();
        final Scanner sc = new Scanner(System.in);
        final PlayField pf = new PlayField();

        for (int i = 0; i < args.length; i++) {
            if ("-import".equals(args[i])) {
                if (i + 1 < args.length) {
                    pf.importCards(sc, logTrace, args[i + 1]);
                    break;
                }
            }
        }

        while (true) {
            final String initMessage = "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):";
            System.out.println(initMessage);
            logTrace.add(initMessage);

            final String action = sc.nextLine();
            logTrace.add(action);

            switch (action) {
                case "add":
                    pf.addCard(sc, logTrace);
                    break;

                case "remove":
                    pf.removeCard(sc, "", logTrace);
                    break;

                case "import":
                    pf.importCards(sc, logTrace, "");
                    break;

                case "export":
                    pf.exportCards(sc, logTrace, "");
                    break;

                case "ask":
                    pf.askCard(sc, logTrace);
                    break;

                case "log":
                    pf.saveLog(sc, logTrace);
                    break;

                case "hardest card":
                    pf.hardestCard(logTrace);
                    break;

                case "reset stats":
                    pf.resetStat(logTrace);
                    break;

                case "exit":
                    System.out.println("Bye bye!");
                    logTrace.add("Bye bye!");

                    for (int i = 0; i < args.length; i++) {
                        if ("-export".equals(args[i])) {
                            if (i + 1 < args.length) {
                                pf.exportCards(sc, logTrace, args[i + 1]);
                                break;
                            }
                        }
                    }
                    return;
            }

            System.out.println();
            logTrace.add("\n");
        }
    }
}

final class PlayField {
    final private HashMap<String, Integer> mistakes = new HashMap<>();
    final private HashMap<String, String> cards = new HashMap<>();
    final private HashMap<String, String> cardsHelper = new HashMap<>();

    public void addCard(final Scanner sc, final ArrayList<String> logTrace) {
        System.out.println("The card:");
        logTrace.add("The card:");
        final String term = sc.nextLine();
        logTrace.add(term);

        if (cards.containsKey(term)) {
            final String termExists = "The card \"" + term + "\" already exists.";
            System.out.println(termExists);
            logTrace.add(termExists);

        } else {
            final String askDefinition = "The definition of the card:";
            System.out.println(askDefinition);
            logTrace.add(askDefinition);

            final String definition = sc.nextLine();
            logTrace.add(definition);

            if (cards.containsValue(definition)) {
                final String definitionExists = "The definition \"" + definition + "\" already exists.";
                System.out.println(definitionExists);
                logTrace.add(definitionExists);

            } else {
                cards.put(term, definition);
                cardsHelper.put(definition, term);
                mistakes.put(term, 0);

                final String pairAdded = "The pair (\"" + term + "\":\"" + definition + "\") has been added.";
                System.out.println(pairAdded);
                logTrace.add(pairAdded);
            }
        }
    }

    public void removeCard(final Scanner sc, final String inner, final ArrayList<String> logTrace) {
        String remove;

        if ("".equals(inner)) {
            System.out.println("The card:");
            logTrace.add("The card:");

            remove = sc.nextLine();
            logTrace.add(remove);

        } else {
            remove = inner;
        }

        if (cards.containsKey(remove)) {
            cardsHelper.remove(cards.get(remove));
            cards.remove(remove);
            mistakes.remove(remove);

            if ("".equals(inner)) {
                System.out.println("The card has been removed.");
                logTrace.add("The card has been removed.");
            }

        } else {
            final String removeError = "Can't remove \"" + remove + "\": there is no such card.";
            System.out.println(removeError);
            logTrace.add(removeError);
        }
    }

    public void importCards(final Scanner sc, final ArrayList<String> logTrace, final String fileName) throws IOException {
        File file;

        if (!"".equals(fileName)) {
            file = new File(fileName);
        } else {
            System.out.println("File name:");
            logTrace.add("File name:");
            final String name = sc.nextLine();
            logTrace.add(name);
            file = new File(name);
        }

        if (file.isFile() || file.isHidden()) {
            int count = 0;

            try (Scanner tmp = new Scanner(file)) {
                while (tmp.hasNext()) {
                    final String term = tmp.nextLine();
                    final String definition = tmp.nextLine();
                    final int mistake = Integer.parseInt(tmp.nextLine());

                    if (cards.containsKey(term)) {
                        removeCard(tmp, term, logTrace);
                    }

                    cards.put(term, definition);
                    cardsHelper.put(definition, term);
                    mistakes.put(term, mistake);

                    count += 1;
                }
            }

            System.out.println(count + " cards have been loaded.");
            logTrace.add(count + " cards have been loaded.");

        } else {
            System.out.println("File not found.");
            logTrace.add("File not found.");
        }
    }

    public void exportCards(final Scanner sc, final ArrayList<String> logTrace, final String fileName) throws IOException {
        File file;

        if (!"".equals(fileName)) {
            file = new File(fileName);
        } else {
            System.out.println("File name:");
            logTrace.add("File name:");
            final String name = sc.nextLine();
            logTrace.add(name);
            file = new File(name);
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (final var learn : cards.entrySet()) {
                printWriter.println(learn.getKey());
                printWriter.println(learn.getValue());
                printWriter.println(mistakes.get(learn.getKey()));
            }
        }
        System.out.println(cards.size() + " cards have been saved.");
        logTrace.add(cards.size() + " cards have been saved.");
    }

    public void askCard(final Scanner sc, final ArrayList<String> logTrace) {
        System.out.println("How many times to ask?");
        logTrace.add("How many times to ask?");

        final int askTimes = Integer.parseInt(sc.nextLine());
        logTrace.add(String.valueOf(askTimes));

        final Random random = new Random();
        final int poolSize = cards.size();

        for (int i = 0; i < askTimes; i++) {
            final String quest = cards.keySet().toArray()[random.nextInt(poolSize)].toString();
            System.out.println("Print the definition of \"" + quest + "\":");
            logTrace.add("Print the definition of \"" + quest + "\":");
            final String answer = sc.nextLine();
            logTrace.add(answer);

            if (answer.equals(cards.get(quest))) {
                System.out.println("Correct answer.");
                logTrace.add("Correct answer.");

            } else if (cards.containsValue(answer)) {
                mistakes.put(quest, mistakes.get(quest) + 1);
                final String wa1 = "Wrong answer. The correct one is \"" + cards.get(quest)
                        + "\", you've just written the definition of \"" + cardsHelper.get(answer) + "\".";
                System.out.println(wa1);
                logTrace.add(wa1);

            } else {
                mistakes.put(quest, mistakes.get(quest) + 1);
                final String wa2 = "Wrong answer. The correct one is \"" + cards.get(quest) + "\".";
                System.out.println(wa2);
                logTrace.add(wa2);
            }
        }
    }

    public void saveLog(final Scanner sc, final ArrayList<String> logTrace) throws IOException {
        System.out.println("File name:");
        logTrace.add("File name:");
        final String name = sc.nextLine();
        logTrace.add(name);

        final File file = new File(name);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (final String moment : logTrace) {
                printWriter.println(moment);
            }
        }
        System.out.println("The log has been saved.");
    }

    public void hardestCard(final ArrayList<String> logTrace) {
        final ArrayList<String> list = new ArrayList<>();
        int maxMistakes = 0;

        for (final var card : mistakes.entrySet()) {
            if (card.getValue() > maxMistakes) {
                list.clear();
                maxMistakes = card.getValue();
                list.add(card.getKey());
            } else if (card.getValue() != 0 && card.getValue() == maxMistakes) {
                list.add(card.getKey());
            }
        }

        if (maxMistakes == 0) {
            System.out.println("There are no cards with errors.");
            logTrace.add("There are no cards with errors.");

        } else {
            final int size = list.size();
            if (size == 1) {
                final String msg1 = "The hardest card is \"" + list.get(0) + "\"" + ". You have " + maxMistakes
                        + " errors answering them.";
                System.out.println(msg1);
                logTrace.add(msg1);

            } else {
                System.out.print("The hardest cards are ");
                logTrace.add("The hardest cards are ");

                String log = "";
                for (int i = 0; i < size - 1; i++) {
                    System.out.print("\"" + list.get(i) + "\", ");
                    log += "\"" + list.get(i) + "\", ";
                }

                System.out.print("\"" + list.get(size - 1) + "\"");
                log += "\"" + list.get(size - 1) + "\"";

                System.out.println(". You have " + maxMistakes + " errors answering them.");
                log += ". You have " + maxMistakes + " errors answering them.";

                logTrace.add(log);
            }
        }
    }

    public void resetStat(final ArrayList<String> logTrace) {
        for (final String word : mistakes.keySet()) {
            mistakes.put(word, 0);
        }

        System.out.println("Card statistics has been reset.");
        logTrace.add("Card statistics has been reset.");
    }
}
