/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Displays which lockers are open 
 * 	after the 100th student changes the 100th locker 
 * Due: 02/24/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project5CMSC201;

public class LockerPuzzle {

	public static void main(String[] args) {

		// Declare and create an array with 100 elements
		/*
		 * Since the default value for a boolean array or variable is false, this array
		 * represents the closed 100 lockers in the first day of school
		 */
		boolean[] closedLockers = new boolean[100];

		/*
		 * Pass the closedLockers array into the puzzleOfLockers method so that the 100
		 * students do the changes
		 */
		boolean[] someOpenLockers = puzzleOfLockers(closedLockers);

		/*
		 * This calls the displayLockers method, displaying the lockers that are open
		 * after the 100th student
		 */
		displayLockers(someOpenLockers);

	}

	// This method has to do with the n students opening/closing every nth locker
	public static boolean[] puzzleOfLockers(boolean[] lockers) {

		// This for loop reiterates as many times as the array's length, represent the
		// number of students
		/*
		 * All 100 students go through 100 lockers but only change their own n lockers
		 * and every nth locker
		 */
		for (int student = 1; student <= lockers.length; student++) {

			// This for loop reiterates as many times as the array's length per student
			/*
			 * One student goes through 100 lockers but only change their own n lockers and
			 * every nth locker
			 */
			for (int lockerNum = 1; lockerNum <= lockers.length; lockerNum++) {

				/*
				 * Declare int variable index and initialize to int variables lockerNum and
				 * student being multiplied and then subtract 1 from the product to convert in
				 * terms of element position
				 */
				int index = (lockerNum * student) - 1;

				/*
				 * Since index may be out of bounds since there is multiplication involved, this
				 * if statement limits the action of changing the lockers only when index is
				 * between 0 and 99 (100 lockers, in terms of element position)
				 */
				if (index < 100) {

					// If the condition is true, then change lockers
					// If it is open, then close it. And vice versa.
					lockers[index] = !(lockers[index]);
				}
			}
		}
		return lockers;
	}

	// This methods displays the lockers that are open after the 100th student
	public static void displayLockers(boolean[] lockers) {

		// This for loop reiterates as many times as the array's length
		// In this particular program, it will reiterate 100 times for the 100 lockers
		for (int i = 0; i < lockers.length; i++) {
			if (lockers[i] == true) {
				System.out.println("Locker " + (i + 1) + " is open");
			}
		}
	}
}