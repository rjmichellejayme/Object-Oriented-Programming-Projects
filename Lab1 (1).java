
package myPackage1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        // Create three Chicken objects
        Chicken chick1 = new Chicken();
        Chicken chick2 = new Chicken();
        Chicken chick3 = new Chicken();

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to name each chicken and read input
            System.out.println("What do you want to name your Chicken Number 1?: ");
            chick1.name = scanner.nextLine();

            System.out.println("What do you want to name your Chicken Number 2?: ");
            chick2.name = scanner.nextLine();

            System.out.println("What do you want to name your Chicken Number 3?: ");
            chick3.name = scanner.nextLine();
        }

        // Display the names and static variable of each chicken
        System.out.println("The name of the 1st chicken is " + chick1.name + ".");
        System.out.println("Chicken number 1 static variable " + Chicken.chickenCounter);

        System.out.println("The name of the 2nd chicken is " + chick2.name + ".");
        System.out.println("Chicken number 2 static variable " + Chicken.chickenCounter);

        System.out.println("The name of the 3rd chicken is " + chick3.name + ".");
        System.out.println("Chicken number 3 static variable " + Chicken.chickenCounter);
    }
}
