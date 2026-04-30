import java.util.Scanner;

public class WordGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String randomWord = WordGenerator.generateWord();

        int Lives = 5;
        StringBuilder guessedWord = new StringBuilder("_ ".repeat(randomWord.length())); // to represent the partially
                                                                                         // guessed word, it initializes
                                                                                         // the string with underscores
                                                                                         // and spaces

        // Print Hangman sign
        System.out.println("=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=  H A N G - M A N  =");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=\n");

        while (Lives > 0 && guessedWord.indexOf("_") != -1) { // Continue the loop as long as the player has remaining
                                                              // lives AND there is at least one underscore character in
                                                              // the guessedWord
            System.out.println("Word: " + guessedWord);
            System.out.println("Lives Left: " + Lives);
            System.out.print("Enter a Letter: ");

            char guess = scanner.next().charAt(0);

            boolean correctGuess = false;

            for (int i = 0; i < randomWord.length(); i++) { // check if the guessed letter matches any character in the
                                                            // random word
                if (randomWord.charAt(i) == guess) {
                    guessedWord.setCharAt(i * 2, guess); // updates the guessedWord to reveal the correctly guessed
                                                         // letter
                                                         // This line replaces the character at a specific position in
                                                         // the guessedWord with the correctly guessed letter (guess).
                                                         // The multiplication by 2 is used to account for the spaces
                                                         // between the underscores in the guessedWord.
                    correctGuess = true; // sets correctGuess to true
                }
            }

            if (correctGuess) {
                System.out.print("Correct guess! "); // Display correct guess statement
            } else {
                Lives--;
                System.out.print("Incorrect guess. You lose one life. "); // Display incorrect guess statement
            }

            System.out.print("Press Enter to continue..."); // allows the player to see the feedback before proceeding
            scanner.nextLine(); // Wait for the user to press Enter
            scanner.nextLine(); // Consume the Enter key press
            System.out.println(); // Move to the next line
        }

        System.out.println("\n" + guessedWord); // displays the final state of the guessed word

        if (Lives == 0) {
            System.out.println("You ran out of lives. The word was: " + randomWord);
        } else {
            System.out.println("Congratulations! You guessed the word: " + randomWord);
        }

        scanner.close();
    }
}

class WordGenerator {
    private static String[] words = new String[] { "abstract", "argument", "array", "ascii", "binary", "operator",
            "boolean", "block", "break", "byte", "case", "casting", "char", "class", "comment", "compiler",
            "compilation", "constructor", "double", "else", "exception", "field", "final", "float", "for",
            "hexadecimal", "import", "instance", "int", "interpreter", "java", "keyword", "literal", "member", "method",
            "new", "object", "overloading", "overriding", "package", "private", "protected", "public", "reference",
            "return", "scope", "short", "static", "switch", "variable", "void" };

    private static int getRandomIndex() {
        return (int) (Math.random() * words.length);
    }

    public static String generateWord() {
        int index = getRandomIndex();
        return words[index];
    }
}
