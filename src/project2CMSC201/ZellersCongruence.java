package project2CMSC201;
/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Calculate day of the week using Christian Zeller's congruence formula
 * Due: 02/04/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

import java.util.Scanner;

public class ZellersCongruence {

	public static void main(String[] args) {
		
		// Create Scanner object
		Scanner input = new Scanner(System.in);
		
		// Display program's title
		System.out.println("**********Zeller's congruence**********\n");
		
		// Obtain year
		System.out.print("Enter year: eg 2012: ");
		int anyYear = input.nextInt();

		// Obtain month
		System.out.print("Enter month: 1-12: ");
		int monthOfYear = input.nextInt();
		// Convert input 1 to 13 and 2 to 14 of the previous year
		if (monthOfYear == 1) {
			monthOfYear = 13;
			--anyYear;	
		}
		else if (monthOfYear == 1)
		{
			monthOfYear = 14;
			--anyYear;
		}
		
		// Obtain day of the month
		System.out.print("Enter the day of the month: 1-31: ");
		int dayOfMonth = input.nextInt();
		
		// Obtain year of the century
		int yearOfCentury = anyYear % 100;
		// Obtain century
		int century = anyYear / 100;
		// Zeller's congruence formula
		int dayOfWeek = (dayOfMonth + 26 * (monthOfYear + 1)
							/ 10 + yearOfCentury + yearOfCentury
							/ 4 + century / 4 + 5 * century) % 7;
		
		// Assigns day a string literal based on the value of dayOfWeek
		String day = "";
		switch (dayOfWeek) {
		case 0: day = "Saturday";
                break;
        case 1: day = "Sunday";
                break; 
        case 2: day = "Monday";
                break;
        case 3: day = "Tuesday";
                break;
        case 4: day = "Wednesday";
                break;
        case 5: day = "Thursday";
                break;
        case 6: day = "Friday";
                break;
        }
		
		// Display day of the week based on calculations 
		System.out.printf("Day of the week is %s", day);
		
		// Display programmer's name
		System.out.println("\n\n**********By Gabriel I. Feliz**********");
		
		  input.close();
	}
}