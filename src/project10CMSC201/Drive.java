/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program tests the content of Triangle directly 
 * 	GeometricObject indirectly to create a Triangle object.
 * Due: 04/15/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project10CMSC201;

// Import Scanner utility
import java.util.Scanner;

public class Drive {
	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		// Prompt and enter three sides of the triangle
		System.out.print("Enter side 1 of triangle: ");
		double side1 = input.nextDouble();
		System.out.print("Enter side 2 of triangle: ");
		double side2 = input.nextDouble();
		System.out.print("Enter side 3 of triangle: ");
		double side3 = input.nextDouble();

		// Prompt and enter color of the triangle
		System.out.print("Enter color of triangle: ");
		String color = input.next();
		
		// Prompt and enter the fullness of triangle
		System.out.print("Enter whether triangle is filled (yes/no): ");
		String isFilled = input.next();
		
		boolean filled;
		
		if (isFilled.equalsIgnoreCase("yes")) {
			// If isFilled is yes, set filled to true
			filled = true;
		} else {
			// If isFilled is not yes, set filled to false
			filled = false;
		}
		
		/* Create Triangle object while passing arguments 
		 * 	to three-arg constructor */
		Triangle triangle = new Triangle(side1, side2, side3, color, filled);
		
		// Display area, perimeter, and color of triangle
		// Display whether it is filled or not
		System.out.println(triangle);

		// Close Scanner object
		input.close();
	}
}