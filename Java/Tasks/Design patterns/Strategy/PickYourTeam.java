import java.util.Scanner;

class SelectionContext {

    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
        return algorithm.select(persons);
    }
}

interface PersonSelectionAlgorithm {

    Person[] select(Person[] persons);
}

class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {

    int step;

    public TakePersonsWithStepAlgorithm(int step) {
        this.step = step;
    }

    @Override
    public Person[] select(Person[] persons) {
        Person[] out = new Person[(int) Math.ceil(1.0 * persons.length / step)];

        for (int i = 0; i < persons.length; i += step) {
            out[i / step] = persons[i];
        }

        return out;
    }
}

class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {

    int count;

    public TakeLastPersonsAlgorithm(int count) {
        this.count = count;
    }

    @Override
    public Person[] select(Person[] persons) {
        count = Math.min(persons.length, count);
        Person[] out = new Person[count];
        int start = persons.length - count;

        for (int i = start; i < persons.length; i++) {
            out[i - start] = persons[i];
        }

        return out;
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine());
        final Person[] persons = new Person[count];

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine());
        }

        final String[] configs = scanner.nextLine().split("\\s+");

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1]));
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg);

        final Person[] selected = ctx.selectPersons(persons);
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}
