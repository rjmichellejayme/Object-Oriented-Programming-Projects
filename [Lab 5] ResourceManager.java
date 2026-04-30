
package packageCoffee;

// This class manages the resources (water, milk, coffee, and money) of the coffee machine.
public class ResourceManager {
    private int water;
    private int milk;
    private int coffee;
    private double money;

    // Constructor to initialize the resources.
    public ResourceManager() {
        water = 1000;
        milk = 1000;
        coffee = 500;
        money = 0;
    }

    // Getter methods to access the resource levels.
    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public double getMoney() {
        return money;
    }

    // Check if there are enough resources to make a specific coffee.
    public boolean checkResources(Coffee coffee) {
        int waterNeeded = coffee.getWaterCost();
        int milkNeeded = coffee.getMilkCost();
        int coffeeNeeded = coffee.getCoffeeCost();

        if (water < waterNeeded) {
            System.out.println("Sorry, there is not enough water.");
            return false;
        }

        if (milk < milkNeeded) {
            System.out.println("Sorry, there is not enough milk.");
            return false;
        }

        if (this.coffee < coffeeNeeded) {
            System.out.println("Sorry, there is not enough coffee.");
            return false;
        }

        return true;
    }

    // Deduct the resources used to make a coffee and add the money to the balance.
    public void deductResources(Coffee coffee) {
        water -= coffee.getWaterCost();
        milk -= coffee.getMilkCost();
        this.coffee -= coffee.getCoffeeCost();
        money += coffee.getCost();
    }
}