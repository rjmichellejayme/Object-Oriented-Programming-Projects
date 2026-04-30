
package packageCoffee;

// This is an abstract class that serves as the base for different coffee types.
public abstract class Coffee {
    private String name;
    private int waterCost;
    private int milkCost;
    private int coffeeCost;
    private double cost;

    // Constructor to initialize the coffee properties.
    public Coffee(String name, int waterCost, int milkCost, int coffeeCost, double cost) {
        this.name = name;
        this.waterCost = waterCost;
        this.milkCost = milkCost;
        this.coffeeCost = coffeeCost;
        this.cost = cost;
    }

    // Getter methods to access the coffee properties.
    public String getName() {
        return name;
    }

    public int getWaterCost() {
        return waterCost;
    }

    public int getMilkCost() {
        return milkCost;
    }

    public int getCoffeeCost() {
        return coffeeCost;
    }

    public double getCost() {
        return cost;
    }
}

// Subclasses that represent specific coffee types.
class CoffeeEspresso extends Coffee {
    public CoffeeEspresso() {
        super("Espresso", 300, 300, 100, 1.50);
    }
}

class CoffeeLatte extends Coffee {
    public CoffeeLatte() {
        super("Latte", 300, 300, 100, 3.00);
    }
}

class CoffeeCappuccino extends Coffee {
    public CoffeeCappuccino() {
        super("Cappuccino", 300, 300, 100, 2.50);
    }
}