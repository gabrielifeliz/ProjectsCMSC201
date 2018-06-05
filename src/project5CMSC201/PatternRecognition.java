/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: that prompts the user to enter the number of rows and columns 
 * 	of a two-dimensional list and then the values in the list and displays True 
 *  if the list contains four consecutive numbers with the same value. 
 *  Otherwise, display False.
 * 	after the 100th student changes the 100th locker 
 * Due: 02/24/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project5CMSC201;

import java.util.Scanner;

public class PatternRecognition {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Enter the number of rows in a table
		System.out.print("Enter number of rows: ");
		int numOfRows = input.nextInt();
		
		// Enter the number of columns in a table
		System.out.print("Enter number of columns: ");
		int numOfColumns = input.nextInt();

		/* Declare and create two-dimensional array. 
		 * The rows and columns are determined 
		 * from the previous inputs */
		int[][] tableOfNumbers = new int[numOfRows][numOfColumns];
		// Declare and initialize to return value from randomNumsInArray
		int[][] tableOfRandomNumbers = randomNumsInArray(tableOfNumbers);
		
		// Display two-dimensional array
		print2DArray(tableOfRandomNumbers);
		
		/* Print out whether the array has any column, any row, 
		or any diagonal with four consecutive numbers */
		System.out.println(isConsecutiveFour(tableOfRandomNumbers));

		// Close Scanner object input
		input.close();
	}

	// This method assigns random numbers from 0 to 9 to the empty 2D array
	public static int[][] randomNumsInArray(int[][] matrix) {
		
		for (int row = 0; row < matrix.length; row++) {
			  for (int column = 0; column < matrix[row].length; column++) {
			    matrix[row][column] = (int)(Math.random() * 10);
			  }
		}

		return matrix;
	}
	
	
	/* This method's task is to print each value in 
	 * the two-dimensional array as a form of a matrix */
	public static void print2DArray(int[][] matrix) {

		/* This for loop reiterates as many times 
		as the number of rows in the matrix */
		/*
		 * It prints each value in the each row 
		 */
		for (int row = 0; row < matrix.length; row++) {
			/* This for loop reiterates as many times 
			as the number of columns in the matrix */
			/*
			 * It prints each value in the current row
			 */
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	
	// This method checks the rows for four consecutive numbers
	public static boolean rowCheck(int[][] matrix) {
		// Declare return variable and initialize it to false
		boolean isConsecutiveRow = false;
		
		/* This for loop reiterates as many times 
			as the number of rows in the matrix */
		/*
		 * It checks each value in the each row 
		 */
		for (int row = 0, rowCounter = 0; row < matrix.length; row++) {
			int startingPosition = matrix[row][0];

			/* This for loop reiterates as many times 
			as the number of columns in the matrix */
			/*
			 * It checks each value in the current row
			 */
			for (int column = 0; column < matrix[row].length; column++) {
				if (startingPosition == matrix[row][column]) {
					// Increase counter by 1 if the starting value is equal to the next
					rowCounter++;

					if (rowCounter == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers in any row
						 */
						isConsecutiveRow = true;
					}
				} else {
					// Replace starting position with another
					startingPosition = matrix[row][column];
					// Return the counter back to 1
					rowCounter = 1;
				}
			}
		}
		return isConsecutiveRow;
	}

	// This method checks the rows for four consecutive numbers
	public static boolean columnCheck(int[][] matrix) {
		// Declare return variable and initialize it to false
		boolean isConsecutiveColumn = false;

		/* This for loop reiterates as many times 
		as the number of columns in the matrix */
		/*
		 * It checks each value in the each column 
		 */
		for (int column = 0, columnCounter = 0; column < matrix[0].length; column++) {
			int startingPosition = matrix[0][column];

			/* This for loop reiterates as many times 
			as the number of rows in the matrix */
			/*
			 * It checks each value in the current column
			 */
			for (int row = 0; row < matrix.length; row++) {
				if (startingPosition == matrix[row][column]) {
					// Increase counter by 1 if the starting value is equal to the next
					columnCounter++;

					if (columnCounter == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers in any column
						 */
						isConsecutiveColumn = true;
					}
				} else {
					// Replace starting position with another
					startingPosition = matrix[row][column];
					// Return the counter back to 1
					columnCounter = 1;
				}
			}
		}
		return isConsecutiveColumn;
	}

	public static boolean leftUpRightCheck(int[][] matrix) {
		// Declare return variable and initialize it to false
		boolean isConsecutiveDiagonally = false;

		/* This for loop reiterates as many times 
		as the starting row number is zero */
		/*
		 * It checks each value diagonally (up right)
		 */
		for (int startingRow = matrix.length - 1; startingRow > 0; startingRow--) {
			int row = startingRow, column = 0, 
					isConsecutiveLeftUpRight = 0,
					startingPosition = matrix[row][column];

			/* This for loop reiterates as many times 
			as the row number is less than zero */
			/*
			 * It checks each value in the current diagonal pattern (up right)
			 */
			for (row = startingRow; row >= 0; column++, row--) {
				if (matrix[row][column] == startingPosition) {
					// Increase counter by 1 if the starting value is equal to the next					
					isConsecutiveLeftUpRight++;
					
					if (isConsecutiveLeftUpRight == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers diagonally
						 * (bottom left going up right)
						 */
						isConsecutiveDiagonally = true;
					}
				} else {
					// Replace starting position with another					
					startingPosition = matrix[row][column];
					// Return the counter back to 1
					isConsecutiveLeftUpRight = 1;
				}
			}
		}

		return isConsecutiveDiagonally;
	}

	public static boolean rightUpRightCheck(int[][] matrix) {
		// Declare return variable and initialize it to false		
		boolean isConsecutiveDiagonally = false;

		/* This for loop reiterates as many times until the starting column number is
		 the number of columns in the array */
		/*
		 * It checks each value diagonally (up right)
		 */
		for (int startingColumn = 0; startingColumn < matrix[0].length; startingColumn++) {
			int row = matrix.length - 1, column = startingColumn, 
					isConsecutiveRightUpRight = 0,
					startingPosition = matrix[row][column];

			/* This for loop reiterates as many times 
			until the row number is less than zero and
			column is the equal to length */
			/*
			 * It checks each value in the current diagonal pattern (up right)
			 */
			for (column = startingColumn; (column < matrix[0].length) && (row >= 0); column++, row--) {
				if (matrix[row][column] == startingPosition) {
					// Increase counter by 1 if the starting value is equal to the next					
					isConsecutiveRightUpRight++;
					
					if (isConsecutiveRightUpRight == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers diagonally
						 * (bottom right going up right)
						 */
						isConsecutiveDiagonally = true;
					}
				} else {
					// Replace starting position with another										
					startingPosition = matrix[row][column];
					// Return the counter back to 1					
					isConsecutiveRightUpRight = 1;
				}
			}
		}

		return isConsecutiveDiagonally;
	}
	
	public static boolean leftUpLeftCheck(int[][] matrix) {
		// Declare return variable and initialize it to false
		boolean isConsecutiveDiagonally = false;

		/* This for loop reiterates as many times 
		as the starting column number is zero */
		/*
		 * It checks each value diagonally (up left)
		 */
		for (int startingColumn = matrix[0].length - 1; startingColumn > 0; startingColumn--) {
			int column = startingColumn, row = matrix.length - 1, 
					isConsecutiveLeftUpLeft = 0,
					startingPosition = matrix[row][column];

			/* This for loop reiterates as many times 
			as the row number is less than zero */
			/*
			 * It checks each value in the current diagonal pattern (up left)
			 */
			for (column = startingColumn; (row >= 0) && (column >= 0); column--, row--) {
				if (matrix[row][column] == startingPosition) {
					// Increase counter by 1 if the starting value is equal to the next					
					isConsecutiveLeftUpLeft++;
					
					if (isConsecutiveLeftUpLeft == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers diagonally
						 * (left going up left)
						 */
						isConsecutiveDiagonally = true;
					}
				} else {
					// Replace starting position with another					
					startingPosition = matrix[row][column];
					// Return the counter back to 1
					isConsecutiveLeftUpLeft = 1;
				}
			}
		}

		return isConsecutiveDiagonally;
	}
	
	public static boolean rightUpLeftCheck(int[][] matrix) {
		// Declare return variable and initialize it to false		
		boolean isConsecutiveDiagonally = false;

		/* This for loop reiterates as many times until the starting row number is
		 the number of row in the array */
		/*
		 * It checks each value diagonally (up right)
		 */
		for (int startingRow = 1 ; startingRow < matrix.length; startingRow++) {
			int row = startingRow, column = matrix[0].length - 1, 
					isConsecutiveRightUpLeft = 0,
					startingPosition = matrix[row][column];

			/* This for loop reiterates as many times 
			until the row number is less than zero */
			/*
			 * It checks each value in the current diagonal pattern (up right)
			 */
			for (row = startingRow; row >= 0; column--, row--) {
				if (matrix[row][column] == startingPosition) {
					// Increase counter by 1 if the starting value is equal to the next					
					isConsecutiveRightUpLeft++;
					
					if (isConsecutiveRightUpLeft == 4) {
						/* Assign return variable to true
						 * if there are four consecutive numbers diagonally
						 * (right going up left)
						 */
						isConsecutiveDiagonally = true;
					}
				} else {
					// Replace starting position with another										
					startingPosition = matrix[row][column];
					// Return the counter back to 1					
					isConsecutiveRightUpLeft = 1;
				}
			}
		}

		return isConsecutiveDiagonally;
	}
	
	/* Return true to isConsecutiveFour if the array has any column, any row, 
	or any diagonal with four consecutive numbers */
	public static boolean isConsecutiveFour(int[][] values) {
		return rowCheck(values) || columnCheck(values) ||
				leftUpRightCheck(values) || rightUpRightCheck(values) ||
				leftUpLeftCheck(values) || rightUpLeftCheck(values);	
	}
}