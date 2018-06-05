/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program catches the InputMismatchException by asking 
 * 	the user to re-enter an integer. After two integers are entered, the program
 * 	displays their sum.
 * Due: 04/08/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project9CMSC201;

// Import Scanner and InputMismatch Exception utilities
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Declare and initialize boolean variable to true
		boolean continueInput = true;

		/*
		 * Declare int variables num1 (first integer input), num2 (second integer
		 * input), and total (sum of two integer inputs) initialized to zero
		 */
		int num1, num2, total = 0;

		do {
			// Locate the possibility of an InputMismatchException
			try {
				// Prompt and ask for first integer
				System.out.print("Enter an integer: ");
				num1 = input.nextInt();
				// Add first integer to total
				total += num1;
				/*
				 * If the input is an integer, then exit out of the do-while loop by setting
				 * continueInput equal to false
				 */
				continueInput = false;
			} catch (InputMismatchException ex) {
				/*
				 * Catch exception and display message asking the user to enter an integer again
				 */
				System.out.println("Please enter an integer.");
				input.nextLine(); // discard input
			}
		} while (continueInput);

		// Reset condition for integer input in the do-while loop to true
		continueInput = true;

		do {
			// Locate the possibility of an InputMismatchException
			try {
				// Prompt and ask for second integer
				System.out.print("Enter an integer: ");
				num2 = input.nextInt();
				// Add second integer to total
				total += num2;
				/*
				 * If the input is an integer, then exit out of the do-while loop by setting
				 * continueInput equal to false
				 */
				continueInput = false;
			} catch (InputMismatchException ex) {
				/*
				 * Catch exception and display message asking the user to enter an integer again
				 */
				System.out.println("Please enter an integer.");
				input.nextLine(); // discard input
			}
		} while (continueInput);

		// Display total after second input is entered
		System.out.println("The sum of two entered integers is " + total);

		// Close Scanner object
		input.close();
	}
}