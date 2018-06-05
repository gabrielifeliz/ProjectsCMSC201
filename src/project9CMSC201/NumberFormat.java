/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program converts a binary string to a decimal number.
 * Due: 04/08/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project9CMSC201;

// Import Scanner utility
import java.util.Scanner;

public class NumberFormat {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt and enter binary string
		System.out.print("Enter a binary string: ");
		String binaryNum = input.next();

		try {
			/*
			 * Locate the possibility of an exception for the input of a binary string
			 */
			System.out.println("The decimal number for " + "this binary string is " + bin2Dec(binaryNum));
		} catch (NumberFormatException ex) {
			// Catch exception and display message created by the programmer
			System.out.println("Not a binary string");
		}

		// Close Scanner input
		input.close();
	}

	/*
	 * The bin2Dec method with a String parameter and an int return type converts a
	 * binary string to a decimal number
	 */
	public static int bin2Dec(String binaryString) {
		/*
		 * The method parseInt from the Integer class converts a string literal into an
		 * integer. The 2 represents that the string is a binary number entered as a
		 * string
		 */
		int decimalNum = Integer.parseInt(binaryString, 2);
		return decimalNum;
	}
}
