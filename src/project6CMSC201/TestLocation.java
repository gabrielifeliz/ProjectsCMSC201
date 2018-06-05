/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: The program displays the largest number 
 * 	from the entered two-dimensional array and its position
 * Due: 03/18/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */


package project6CMSC201;

// Import Scanner utility
import java.util.Scanner;

public class TestLocation {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Enter number of rows and columns in the array
		System.out.print("Enter the number of rows and columns in the array: ");
		int rowInArray = input.nextInt();
		int columnInArray = input.nextInt();

		/* Declare and create two-dimensional array. The rows and columns are determined
		 * from the previous inputs */
		double[][] matrix = new double[rowInArray][columnInArray];

		// Enter values in two-dimensional array
		System.out.println("Enter the array: ");
		for (int x = 0; x < matrix.length; x++) {
		  for (int y = 0; y < matrix[x].length; y++) {
		    matrix[x][y] = input.nextDouble(); 
		  }
		}
		
		// Declare Location variable and initialize to return value in locateLargest
		Location loc = locateLargest(matrix);

		// Display message with the location of the largest number in the array
		System.out.print("The location of the largest element is");
		// The display with format allows the maximum value to be truncated to two decimal places
		System.out.printf(" %.1f", loc.maxValue);
		// Display position in the array in terms of coordinates
		System.out.print(" at " + "(" + loc.row + ", " + loc.column + ")");

		// Close Scanner object
		input.close();

	}

	public static Location locateLargest(double[][] a) {
		// Create instance of Location class
		Location location = new Location();

		// Initialize public data fields in Location class
		location.row = 0;
		location.column = 0;
		location.maxValue = a[0][0];
		
		/* This for loop reiterates as many times 
		as the number of rows in the matrix */
		// It checks each value in each row
		for (int row = 0; row < a.length; row++) {
			/* This for loop reiterates as many times 
			as the number of columns in the matrix */
			// It checks each value in the current row
			for (int column = 0; column < a[row].length; column++) {
				/* If the number in the current position 
				 * is greater than the initial maxValue,
				 * then assign row, column and that 
				 * number in the current position to the 
				 * data fields from Location class */
					if (a[row][column] > location.maxValue) {
						location.row = row;
						location.column = column;
						location.maxValue = a[row][column];
					}
			}
		}
		// Return instance of Location class
		return location;
	}
}