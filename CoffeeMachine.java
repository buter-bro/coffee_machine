package machine;
import java.util.Scanner;

public class CoffeeMachine {

    int[] ingr = {400, 540, 120, 9, 550};
    int type;

    public void stateOfCoffeeMachine() {
        System.out.printf("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d of disposable cups%n$%d of money%n%n", ingr[0], ingr[1], ingr[2], ingr[3], ingr[4]);
    }
    public void coffeeType() {
        int[] espresso = {250, 0, 16, 1, -4};
        int[] latte = {350, 75, 20, 1, -7};
        int[] cappuccino = {200, 100, 12, 1, -6};
        switch (type) {
            case 1:
                if (ingr[0] - espresso[0] < 0 || ingr[1] - espresso[1] < 0 || ingr[2] - espresso[2] < 0 || ingr[3] - espresso[3] < 0 || ingr[4] - espresso[4] < 0) {
                    System.out.println("I have not enough resources!");
                    break;
                }
                for (int i = 0; i < 5; i++) {
                    ingr[i] -= espresso[i];
                }
                System.out.println("I have enough resources, making you a coffee!\n");
                break;
            case 2:
                if (ingr[0] - latte[0] < 0 || ingr[1] - latte[1] < 0 || ingr[2] - latte[2] < 0 || ingr[3] - latte[3] < 0 || ingr[4] - latte[4] < 0) {
                    System.out.println("I have not enough resources!");
                    break;
                }
                for (int i = 0; i < 5; i++) {
                    ingr[i] -= latte[i];
                }
                System.out.println("I have enough resources, making you a coffee!\n");
                break;
            case 3:
                if (ingr[0] - cappuccino[0] < 0 || ingr[1] - cappuccino[1] < 0 || ingr[2] - cappuccino[2] < 0 || ingr[3] - cappuccino[3] < 0 || ingr[4] - cappuccino[4] < 0) {
                    System.out.println("I have not enough resources!");
                    break;
                }
                for (int i = 0; i < 5; i++) {
                    ingr[i] -= cappuccino[i];
                }
                System.out.println("I have enough resources, making you a coffee!\n");
                break;
        }
    }
    public boolean action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String act = scanner.next();
        if (act.equals("buy")) {
            buy();
            return true;
        } else if (act.equals("fill")) {
            fill();
            return true;
        } else if (act.equals("take")) {
            take();
            return true;
        } else if (act.equals("remaining")) {
            stateOfCoffeeMachine();
            return true;
        } else if (act.equals("exit")) {
            return false;
        }
        return false;
    }
    public void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String buyAct = scanner.next();
        if (buyAct.equals("back")) {
            action();
        } else if (buyAct.matches("[0-9]+")) {
            type = Integer.parseInt(buyAct);
            coffeeType();
        }
    }
    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        ingr[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        ingr[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        ingr[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        ingr[3] += scanner.nextInt();
        //stateOfCoffeeMachine(water, milk, beans, cups, money);
    }
    public void take() {
        System.out.printf("I gave you %d$%n", ingr[4]);
        ingr[4] = 0;
    }
    public void checkAmountOfCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();
        ingr[0] = water / (200);
        ingr[1] = milk / (50);
        ingr[2] = beans / (15);
        int minCntOfCups = ingr[0];
        for (int i = 1; i < 3; i++) {
            if (ingr[i] < minCntOfCups) {
                minCntOfCups = ingr[i];
            }
        }
        if (minCntOfCups == cups) {
            System.out.print("Yes, I can make that amount of coffee");
        } else if (minCntOfCups > cups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", minCntOfCups - cups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", minCntOfCups);
        }
    }
    public static void main(String[] args) {
        CoffeeMachine coffeemachine = new CoffeeMachine();
        while (true) {
            boolean isContinue = coffeemachine.action();
            if (!isContinue) {
                break;
            }
        }
    }
}