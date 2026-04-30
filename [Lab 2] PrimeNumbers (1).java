import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        int n;
        int count = 0;

        // Prompt the user to enter a number
        System.out.print("Enter a number to check if it's prime: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        // Checks if the entered number is less than or equal to 1
        if (n <= 1) {
            System.out.println("Nope! This is not a prime number.");
            in.close();
            return;
        }

        // Check for factors of the entered number
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
                break; // Exit the loop as soon as a factor is found
            }
        }

        // Checks the value of count and determine then print if the number is prime or
        // not
        if (count > 0) {
            System.out.println("Nope! This is not a prime number.");
        } else {
            System.out.println("Yup! This is a prime number.");
        }
        in.close();
    }
}
