package machine;
import java.util.*;

public class CoffeeMachine {
    private static final Scanner sc = new Scanner(System.in);

    private static int hasWater = 400;
    private static int hasMilk = 540;
    private static int hasBeans = 120;
    private static int hasCups = 9;
    private static int hasMoney = 550;

    private static void buyDrink() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String pick = sc.next();

        switch (pick) {
            case "1":
                if (hasWater < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (hasBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (hasCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                hasWater -= 250;
                hasBeans -= 16;
                hasCups -= 1;
                hasMoney += 4;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "2":
                if (hasWater < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (hasMilk < 75) {
                    System.out.println("Sorry, not enough coffee milk!");
                    break;
                }
                if (hasBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (hasCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                hasWater -= 350;
                hasMilk -= 75;
                hasBeans -= 20;
                hasCups -= 1;
                hasMoney += 7;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "3":
                if (hasWater < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }
                if (hasMilk < 100) {
                    System.out.println("Sorry, not enough coffee milk!");
                    break;
                }
                if (hasBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }
                if (hasCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                }
                hasWater -= 200;
                hasMilk -= 100;
                hasBeans -= 12;
                hasCups -= 1;
                hasMoney += 6;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "back":
                break;
        }
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        hasWater += sc.nextInt();

        System.out.println("Write how many ml of milk do you want to add");
        hasMilk += sc.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        hasBeans += sc.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add");
        hasCups += sc.nextInt();
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + hasMoney);
        hasMoney = 0;
    }

    private static void machineHas() {
        System.out.println("The coffee machine has:");
        System.out.println(hasWater + " of water");
        System.out.println(hasMilk + " of milk");
        System.out.println(hasBeans + " of coffee beans");
        System.out.println(hasCups + " of disposable cups");
        System.out.println(hasMoney + " of money");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

            String action = sc.next();
            System.out.println();

            switch (action) {
                case "buy":
                    buyDrink();
                    break;

                case "fill":
                    fillMachine();
                    break;

                case "take":
                    takeMoney();
                    break;

                case "remaining":
                    machineHas();
                    break;

                case "exit":
                    return;
            }
        }
        
    }
}