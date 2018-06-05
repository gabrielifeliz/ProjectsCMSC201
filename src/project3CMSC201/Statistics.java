/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Calculate the mean and standard deviation of ten numbers from input.
 * Due: 02/12/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz
 */

package project3CMSC201;

import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		/* Declare variable for total of numbers 
		   and initialize it to zero */ 
		double numbersTotal = 0;
		/* Declare variable for total of numbers squared
		   (used in standard deviation formula) 
		   and initialize it to zero */ 
		double numbersTotalSquared = 0;
		// Declare variable for how many numbers have been entered
		int count;
		
		/* This for loop calculates the total of numbers from input
		to calculate mean and standard deviation */
		for (count = 0; count < 10; count++) {
			System.out.print("Enter a number: ");
			double numbersEntered = input.nextDouble();
			numbersTotal += numbersEntered;
			numbersTotalSquared += (Math.pow(numbersEntered, 2.0));
		}
		
		/* Calculate mean and standard deviation by plugging in the 
		   total of numbers and total of numbers squared to the formulas */
		double mean = numbersTotal / count;
		double standardDeviation = Math.sqrt((numbersTotalSquared 
				- ((Math.pow(numbersTotal, 2.0) /count)))/(count - 1));

		// Display mean and standard deviation
		System.out.println("The mean is " + mean);
		System.out.println("The standard deviation is " + standardDeviation);
		
		  input.close();
	}
}