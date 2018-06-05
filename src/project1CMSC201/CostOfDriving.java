package project1CMSC201;
/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Calculate cost of a trip
 * Due: 01/28/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

// Import Scanner utility
import java.util.Scanner;

public class CostOfDriving {

	public static void main(String[] args) {

		// Declare a Scanner object called input to read data from the user.
		Scanner input = new Scanner(System.in);
		
		// Obtain driving distance
		System.out.print("Enter distance to drive: ");
		float drivingDistance = input.nextFloat();
		
		// Obtain miles per gallon
		System.out.print("Enter fuel efficiency in miles per gallon: ");
		float fuelEfficiency = input.nextFloat();
		
		// Obtain price per gallon
		System.out.print("Enter price per gallon: ");
		float gallonPrice = input.nextFloat();
		
		// Calculate cost of driving
		float drivingCost = (drivingDistance / fuelEfficiency) * gallonPrice;
		
		// Display cost of driving
		System.out.println("The cost of driving is $" + drivingCost);

		input.close();
	}

}