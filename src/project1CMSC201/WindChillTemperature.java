package project1CMSC201;
/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Measure wind chill index or how cold it is outside
 * Due: 01/28/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

// Import Scanner utility
import java.util.Scanner;

public class WindChillTemperature {

	public static void main(String[] args) {
		
		// Declare a Scanner object called input to read data from the user.
		Scanner input = new Scanner(System.in);
		
		// Obtain outside temperature.
		System.out.print("Enter outside temperature between -58 and 41 in Fahrenheit: ");
		double outsideTemperature = input.nextDouble();
		
		// Obtain wind speed.
		System.out.print("Enter wind speed (>=2) in miles per hour: ");
		double windSpeed = input.nextDouble();
		
		// Calculate wind-chill temperature.
		double wind_ChillTemperature = 
				35.74 + (0.6215 * outsideTemperature)
				- (35.75 * (Math.pow(windSpeed, 0.16)))
				+ (0.4275 * outsideTemperature *(Math.pow(windSpeed, 0.16)));
		
		// Display wind-chill temperature.
		/* The variable wind_ChillTemperature is converted to float datatype
			so that it displays less decimal places. */	
		System.out.println("The wind chill index is: " 
				+ (float) wind_ChillTemperature);	
		
		  input.close();
	}

}