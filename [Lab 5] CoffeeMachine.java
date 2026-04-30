package packageCoffee;

import java.util.Scanner;

public class CoffeeMachine {
    private ResourceManager resourceManager; // A reference to manage resources like coffee, water, milk, and money.
    private Scanner scanner; // A tool for reading user input.

    // Constructor for the CoffeeMachine, initialized with a ResourceManager and Scanner.
    public CoffeeMachine(ResourceManager resourceManager, Scanner scanner) {
        this.resourceManager = resourceManager;
        this.scanner = scanner;
    }

    // Default constructor for the CoffeeMachine, using a default ResourceManager and System.in for input.
    public CoffeeMachine() {
        this(new ResourceManager(), new Scanner(System.in));
    }

    // Method to start the coffee machine and interact with the user.
    public void run() {
        boolean isOn = true;
        while (isOn) {
            System.out.println("========================================");
            System.out.println("  Greetings! Welcome to My CoffeeShop!");
            System.out.println("========================================");
            System.out.println("\nWhat Coffee would you like today?");
            System.out.println("   Espresso -  $1.50");
            System.out.println("   Latte - $3.00");
            System.out.println("   Cappuccino - $2.50");

            String choice = scanner.nextLine().toLowerCase(); // Read the user's coffee choice.

            if (choice.equals("off")) {
                System.out.println("========================================");
                System.out.println("Turning off the Coffee Machine. Goodbye!");
                isOn = false; // Turn off the coffee machine.
            } else if (choice.equals("report")) {
                generateReport(); // Display a resource report.
            } else if (isValidChoice(choice)) {
                processDrink(choice); // Prepare and serve the selected coffee.
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for the user to press Enter.
            } else {
                System.out.println("========================================");
                System.out.println("Hmm, this machine does not serve that. Please try again.");
                System.out.println("========================================");
            }
        }
    }

    // Check if the user's coffee choice is valid (espresso, latte, or cappuccino).
    private boolean isValidChoice(String choice) {
        switch (choice) {
            case "espresso":
            case "latte":
            case "cappuccino":
                return true;
            default:
                return false;
        }
    }

    // Prepare and serve the selected coffee.
    private void processDrink(String choice) {
        Coffee coffee;
        switch (choice) {
            case "espresso":
                coffee = new CoffeeEspresso();
                break;
            case "latte":
                coffee = new CoffeeLatte();
                break;
            case "cappuccino":
                coffee = new CoffeeCappuccino();
                break;
            default:
                return;
        }

        if (resourceManager.checkResources(coffee)) { // Check if there are enough resources.
            System.out.println("========================================");
            System.out.println("Please insert coins:");
            double insertedAmount = processCoins(); // Read and calculate the user's payment.
            if (insertedAmount >= coffee.getCost()) { // Check if the payment is sufficient.
                resourceManager.deductResources(coffee); // Deduct the resources used.
                System.out.println("========================================");
                System.out.println("Making your coffee. Please wait...");
                try {
                    Thread.sleep(2000); // Simulate coffee making time (2 seconds).
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double change = insertedAmount - coffee.getCost(); // Calculate the change.
                System.out.printf("\nPayment received. Your change is $%.2f%n", change);
                System.out.printf("Enjoy your %s. Have a great day!%n%n", choice);
            } else {
                System.out.printf("Insufficient payment, the %s costs $%.2f. Money refunded.%n%n", choice, coffee.getCost());
            }
        } else {
            System.out.println("========================================");
            System.out.println("Sorry, there are not enough resources to make the drink.");
            System.out.println("========================================");
        }
    }

    // Read and calculate the coins provided by the user.
    private double processCoins() {
        double amount = 0.0;

        while (true) {
            try {
                int quarters, dimes, nickels, pennies;

                System.out.print("\nQuarters: ");
                quarters = scanner.nextInt();
                if (quarters < 0) {
                    System.out.println("Quarters cannot be negative.");
                    continue; // Ask for input again.
                }

                System.out.print("Dimes: ");
                dimes = scanner.nextInt();
                if (dimes < 0) {
                    System.out.println("Dimes cannot be negative.");
                    continue; // Ask for input again.
                }

                System.out.print("Nickels: ");
                nickels = scanner.nextInt();
                if (nickels < 0) {
                    System.out.println("Nickels cannot be negative.");
                    continue; // Ask for input again.
                }

                System.out.print("Pennies: ");
                pennies = scanner.nextInt();
                if (pennies < 0) {
                    System.out.println("Pennies cannot be negative.");
                    continue; // Ask for input again.
                }

                scanner.nextLine(); // Consume the newline character.

                amount = quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01; // Calculate the total payment.
                System.out.printf("Total Payment: $%.2f%n", amount);
                break; // Valid input, exit the loop.
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid coin input. Please enter valid coin quantities.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        return amount;
    }


    // Generate a report on the available resources.
    private void generateReport() {
        System.out.println("==============SUPPLY REPORT=============");
        System.out.printf("  Coffee: %dg%n", resourceManager.getCoffee());
        System.out.printf("  Water: %dml%n", resourceManager.getWater());
        System.out.printf("  Milk: %dml%n", resourceManager.getMilk());
        System.out.printf("  Money: $%.2f%n%n", resourceManager.getMoney());
    }

    // Entry point of the application.
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.run(); // Start the CoffeeMachine and interact with the user.
    }
}
