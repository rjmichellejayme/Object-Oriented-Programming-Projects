import java.util.Scanner;
import java.time.LocalDate;

public class Calendar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int month = 0;
		int year = 0;

		while (true) {
			// Get a valid month from user input
			month = getValidMonth(in);

			// Get a valid year from user input
			year = getValidYear(in);

			// Create a LocalDate object for the specified month and year
			LocalDate date = LocalDate.of(year, month, 1);

			// Get the full name of the month and print it along with the year
			String monthName = getMonthName(month);
			System.out.printf("%s, %d\n", monthName, year);
			System.out.println("Sun Mon Tue Wed Thu Fri Sat");

			// Calculate the starting day of the month and the number of days in the month
			int startDay = date.getDayOfWeek().getValue() % 7;
			int numDays = date.lengthOfMonth();

			// Display the calendar for the specified month
			displayCalendar(startDay, numDays);

			// Ask the user if they want to enter another date and handle their response
			System.out.print("Do you want to enter another date (yes/no)? ");
			String answer = in.next();
			if (!answer.equalsIgnoreCase("yes")) {
				break; // Exit the loop if the user does not want to enter another date
			}
		}

		in.close();
	}

	private static int getValidMonth(Scanner in) {
		int month;
		while (true) {
			// Prompt the user for a month number and validate the input
			System.out.print("Enter Month Number (1-12): ");
			if (in.hasNextInt()) {
				month = in.nextInt();
				if (month >= 1 && month <= 12) {
					break; // Exit the loop if the input is valid
				}
			}
			System.out.println("Invalid Input! Please choose between 1-12.");
			in.nextLine(); // Consume the invalid input to prevent an infinite loop
		}
		return month;
	}

	private static int getValidYear(Scanner in) {
		int year;
		while (true) {
			// Prompt the user for a year and validate the input
			System.out.print("Enter Year Number (1-10000): ");
			if (in.hasNextInt()) {
				year = in.nextInt();
				if (year >= 1 && year <= 10000) {
					break; // Exit the loop if the input is valid
				}
			}
			System.out.println("Invalid Input! Please choose between 1-10000.");
			in.nextLine(); // Consume the invalid input to prevent an infinite loop
		}
		return year;
	}

	private static void displayCalendar(int startDay, int numDays) {
		// Print leading spaces to align the first day of the month correctly
		for (int i = 0; i < startDay; i++) {
			System.out.print("    ");
		}

		// Print the day numbers with proper formatting
		for (int i = 1; i <= numDays; i++) {
			System.out.printf("%3d ", i);
			if ((startDay + i - 1) % 7 == 6) {
				System.out.println(); // Start a new line at the end of the week
			}
		}

		// Print a new line if the last week of the month is not complete
		if ((startDay + numDays - 1) % 7 != 6) {
			System.out.println();
		}
	}

	private static String getMonthName(int month) {
		// Array of month names (index 0 to 11 corresponds to January to December)
		String[] monthNames = {
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"
		};

		// Return the month name corresponding to the given month number
		return monthNames[month - 1];
	}
}
