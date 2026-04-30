
package myPackage1; // Package declaration

public class Chicken {
    public String name; // Public instance variable to store the name
    public static int chickenCounter = 0; // Public static variable to count Chicken objects

    public Chicken() {
        chickenCounter++; // Increment the chickenCounter when a Chicken object is created
    }
}
