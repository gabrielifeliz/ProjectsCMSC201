/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program removes occurrences of a specified String from a File
 * 	through arguments from command line prompt
 * Due: 04/08/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project9CMSC201;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RmvText {
	public static void main(String[] args) throws Exception {
		// Check command line parameter usage
		if (args.length != 2) {
			// Display message to let user know incorrect number of arguments
			System.out.println("Invalid arguments.");
			// Display correct command line parameter usage
			System.out.println("Usage: java RmvText wordToBeRemoved filename");
			// Exit at this point
			System.exit(1);
		}

		// Check if the file exists
		// Create a File object named by second argument 
		File fileName = new File(args[1]);
		if (!fileName.exists()) {
			// Display that the file does not exist
			System.out.println("Source file " + args[1] + " does not exist.");
			// Exit at this point
			System.exit(2);
		}

		// Read text from the file and save it in a string builder
		StringBuilder sb = new StringBuilder();
		String lineSeparator = System.getProperty("line.separator");

		try {
			// Locate any possible FileNotFoundException in this piece of code
			// Create Scanner object
			Scanner input = new Scanner(fileName);
			boolean firstLine = true;
			// The while loop is responsible for removing the occurrences of a specified String
			while (input.hasNext()) {
				// First String variable reads a line from the file
				String s1 = input.nextLine();
				/* Second String variable replaces all occurrences of 
				 * the first argument from the command line prompt to an empty string*/
				String s2 = s1.replaceAll(args[0], "");
				if (firstLine) {
					sb.append(s2);
					firstLine = false;
				} else {
					sb.append(lineSeparator + s2);
				}
			}
			// Close Scanner object
			input.close();
		} catch (FileNotFoundException e) {
			// Catch exception and perform action to handle it
			e.printStackTrace();
		}

		// Write back to the file
		try {
			// Locate any possible FileNotFoundException in this piece of code
			// Create PrintWriter object
			PrintWriter output = new PrintWriter(fileName);
			// Print String representation of object to the system
			System.out.println(sb);
			// Print String representation of object in file
			output.println(sb);
			// Close PrintWriter object
			output.close();
		} catch (FileNotFoundException e) {
			// Catch exception and perform action to handle it
			e.printStackTrace();
		}
	}
}