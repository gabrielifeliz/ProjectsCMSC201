package project4CMSC201;

/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: Display whether a credit card number is valid or invalid.
 * Due: 02/18/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz
 */

// 4388576018410707
import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) {
		/* Assigns the value returned in inputData method
			to long variable creditCard */
		long creditCard = inputData();
		
		/* Calls displayResult method that displays 
			whether the card is valid or invalid */
		displayResult(creditCard);

	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		/* Sum of single-digit number from doubling second digit
			and all digits from odd places*/
		int evenAndOddPlaceSum = sumOfOddPlace(number) + sumOfDoubleEvenPlace(number);
		
		/* Assign value returned from getSize method, 
			which is the number of digits in credit card number */
		int numOfDigits = getSize(number);
		
		/* Assigns true to creditCardValidationif all criteria for a credit card is met
			- number of digits must be between 13 and 16
			- prefix of credit card number must be either 4, 5, 6, 37
			- evenAndOddPlaceSum must be divisible by 10 
			or false if at least one of them is not met */
		boolean creditCardValidation = (((numOfDigits >= 13) && (numOfDigits <= 16))
				&& ((evenAndOddPlaceSum % 10) == 0)
				&& ((prefixMatched(number, 4) == true) || (prefixMatched(number, 5) == true)
						|| (prefixMatched(number, 6) == true) || (prefixMatched(number, 37) == true))) ? true : false;

		return creditCardValidation;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		
		// Get 1st second digit from right to left
		int remaining1 = (int) (number % 1e2);
		int secondDigit1 = remaining1 / (int) (1e1);

		// Get 2nd digit from right to left
		int remaining2 = (int) (number % 1e4);
		int secondDigit2 = remaining2 / (int) (1e3);

		// Get 3rd second digit from right to left
		int remaining3 = (int) (number % 1e6);
		int secondDigit3 = remaining3 / (int) (1e5);

		// Get 4th second digit from right to left
		int remaining4 = (int) (number % 1e8);
		int secondDigit4 = remaining4 / (int) (1e7);

		// Get 5th second digit from right to left
		int remaining5 = (int) (number / 1e9);
		int secondDigit5 = remaining5 % (int) (1e1);

		// Get 6th second digit from right to left
		int remaining6 = (int) (number / 1e11);
		int secondDigit6 = remaining6 % (int) (1e1);

		// Get 7th second digit from right to left
		int remaining7 = (int) (number / 1e13);
		int secondDigit7 = remaining7 % (int) (1e1);

		// Get 8th second digit from right to left
		int remaining8 = (int) (number / 1e15);
		int secondDigit8 = remaining8 % (int) (1e1);

		int singleDigitEvenPlace1 = getDigit(secondDigit1);
		int singleDigitEvenPlace2 = getDigit(secondDigit2);
		int singleDigitEvenPlace3 = getDigit(secondDigit3);
		int singleDigitEvenPlace4 = getDigit(secondDigit4);
		int singleDigitEvenPlace5 = getDigit(secondDigit5);
		int singleDigitEvenPlace6 = getDigit(secondDigit6);
		int singleDigitEvenPlace7 = getDigit(secondDigit7);
		int singleDigitEvenPlace8 = getDigit(secondDigit8);

		/* Assign value returned from getSize method, 
			which is the number of digits in credit card number */
		int numOfDigits = getSize(number);
		
		// Initialize variable to zero to accumulate values
		int sumDigitEvenPlace = 0;

		// If credit card number has 13 digits, add only 1st 6 second digits
		if (numOfDigits == 13) {
			sumDigitEvenPlace = singleDigitEvenPlace1 + singleDigitEvenPlace2 + singleDigitEvenPlace3
					+ singleDigitEvenPlace4 + singleDigitEvenPlace5 + singleDigitEvenPlace6;
		// If credit card number has 14 or 15 digits, add only 1st 7 second digits		
		} else if ((numOfDigits == 14) || (numOfDigits == 15)) {
			sumDigitEvenPlace = singleDigitEvenPlace1 + singleDigitEvenPlace2 + singleDigitEvenPlace3
					+ singleDigitEvenPlace4 + singleDigitEvenPlace5 + singleDigitEvenPlace6 + singleDigitEvenPlace7;
		// If credit card number has 16 digits, add only 1st 8 second digits		
		} else if (numOfDigits == 16) {
			sumDigitEvenPlace = singleDigitEvenPlace1 + singleDigitEvenPlace2 + singleDigitEvenPlace3
					+ singleDigitEvenPlace4 + singleDigitEvenPlace5 + singleDigitEvenPlace6 + singleDigitEvenPlace7
					+ singleDigitEvenPlace8;
		}

		return sumDigitEvenPlace;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of the
	 * two digits
	 */
	public static int getDigit(int number) {
		// Double those digits in even place of credit card number
		int singleDigit = (number *= 2);
		
		/* If doubling of a digit results in a two-digit number, 
		add up the two digits to get a single-digit number */
		if (number > 9) {
			singleDigit = ((number / 10) + (number % 10));
		}

		return singleDigit;
	}

	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		
		// Get 1st first digit from right to left
		int remainingOddPlace1 = (int) (number % 1e1);
		int firstDigit1 = remainingOddPlace1 / (int) (1e0);

		// Get 2nd first digit from right to left
		int remainingOddPlace2 = (int) (number % 1e3);
		int firstDigit2 = remainingOddPlace2 / (int) (1e2);

		// Get 3rd first digit from right to left		
		int remainingOddPlace3 = (int) (number % 1e5);
		int firstDigit3 = remainingOddPlace3 / (int) (1e4);
		
		// Get 4th first digit from right to left
		int remainingOddPlace4 = (int) (number % 1e7);
		int firstDigit4 = remainingOddPlace4 / (int) (1e6);
		
		// Get 5th first digit from right to left
		int remainingOddPlace5 = (int) (number % 1e9);
		int firstDigit5 = remainingOddPlace5 / (int) (1e8);
		
		// Get 6th first digit from right to left
		int remainingOddPlace6 = (int) (number / 1e10);
		int firstDigit6 = remainingOddPlace6 % (int) (1e1);
		
		// Get 7th first digit from right to left
		int remainingOddPlace7 = (int) (number / 1e12);
		int firstDigit7 = remainingOddPlace7 % (int) (1e1);
		
		// Get 8th first digit from right to left
		int remainingOddPlace8 = (int) (number / 1e14);
		int firstDigit8 = remainingOddPlace8 % (int) (1e1);

		/* Assign value returned from getSize method, 
			which is the number of digits in credit card number */
		int numOfDigits = getSize(number);
		
		// Initialize variable to zero to accumulate values
		int sumDigitOddPlace = 0;

		// If credit card number has 13 or 14 digits, add only 1st 7 first digits
		if ((numOfDigits == 13) || (numOfDigits == 14)) {
			sumDigitOddPlace = firstDigit1 + firstDigit2 + firstDigit3 + firstDigit4 + firstDigit5 + firstDigit6
					+ firstDigit7;
		
		// If credit card number has 15 or 16 digits, add only 1st 8 first digits		
		} else if ((numOfDigits == 15) || (numOfDigits == 16)) {
			sumDigitOddPlace = firstDigit1 + firstDigit2 + firstDigit3 + firstDigit4 + firstDigit5 + firstDigit6
					+ firstDigit7 + firstDigit8;
		}

		return sumDigitOddPlace;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		boolean prefixValidation;
		
		// Assign first one number from the left of number to prefixOneDigit
		long prefixOneDigit = getPrefix(number, 1);
		
		// Assign first two numbers from the left of number to prefixOneDigit		
		long prefixTwoDigit = getPrefix(number, 2);
		/* Assign true to prefixValidation if the prefix from the credit card number 
		match either 4, 5, 6, or 37 or false if it does not match to any of them */
		prefixValidation = (((d == 4) && (prefixOneDigit == d)) || ((d == 5) && (prefixOneDigit == d))
				|| ((d == 6) && (prefixOneDigit == d))) ? true : (((d == 37) && (prefixTwoDigit == d)) ? true : false);

		return prefixValidation;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		int digitNum;
		/* The for loop determines the number of digits
			in the credit card number and stores it in digitNum
			by dividing this number until the quotient is zero */
		for (digitNum = 0; d != 0; ++digitNum) {
			d /= 10;
		}

		return digitNum;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits in
	 * number is less than k, return number.
	 */

	public static long getPrefix(long number, int k) {
		// Initialize long variable prefix to store prefix from credit card number
		long prefix = 0;
		
		/* Assign value returned from getSize method, 
			which is the number of digits in credit card number */
		int numOfDigits = getSize(number);
		
		// If desired number of prefixes taken is one
		if (k == 1) {
			// If credit card number has 13 digits, then divide number by 12
			if (numOfDigits == 13) {
				prefix = (number / (int) (1e5)) / (int) (1e7);
			
			// If credit card number has 14 digits, then divide number by 13
			} else if (numOfDigits == 14) {
				prefix = (number / (int) (1e6)) / (int) (1e7);
			
			// If credit card number has 15 digits, then divide number by 14
			} else if (numOfDigits == 15) {
				prefix = (number / (int) (1e7)) / (int) (1e7);
			
			// If credit card number has 16 digits, then divide number by 15
			} else if (numOfDigits == 16) {
				prefix = (number / (int) (1e8)) / (int) (1e7);
			}
		// If desired number of prefixes taken is two
		} else if (k == 2) {
			// If credit card number has 13 digits, then divide number by 11
			if (numOfDigits == 13) {
				prefix = (number / (int) (1e4)) / (int) (1e7);
			
			// If credit card number has 14 digits, then divide number by 12
			} else if (numOfDigits == 14) {
				prefix = (number / (int) (1e5)) / (int) (1e7);
			
			// If credit card number has 15 digits, then divide number by 13
			} else if (numOfDigits == 15) {
				prefix = (number / (int) (1e6)) / (int) (1e7);
			
			// If credit card number has 16 digits, then divide number by 14
			} else if (numOfDigits == 16) {
				prefix = (number / (int) (1e7)) / (int) (1e7);
			}
		}

		return prefix;
	}

	/**
	 * input credit card’s number from keyboard Return this credit Card’s number
	 */
	public static long inputData() {
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		// Prompt and enter credit card number
		System.out.print("Enter a credit card number as a long integer: ");
		long creditCardNum = input.nextLong();

		  input.close();

		return creditCardNum;
	}

	/**
	 * Display result using a method println()
	 */
	public static void displayResult(long number) {
		/* Display whether credit card number is valid or invalid
		based on whether isValid method returned true or false */
		System.out.print(number + " is " + (isValid(number) == true ? "valid" : "invalid"));
	}
}