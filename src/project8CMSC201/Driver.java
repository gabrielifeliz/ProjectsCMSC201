/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program contains a Drive class 
 * 	that asks the user what type of object the user 
 * 	would like to create as well as what information 
 * 	s/he would like it to have. The program should 
 * 	then use the object's toString method to print 
 * 	information about that object.
 * Due: 04/01/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project8CMSC201;

// Import Scanner utility
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt and enter choose to create student or employee object
		System.out.println("1) To create a Student");
		System.out.println("2) To create an Employee");
		System.out.print("Choice: ");
		int choice = input.nextInt();

		// Enter name of student/employee
		System.out.print("Enter a name: ");
		String firstName = input.next();
		String lastName = input.nextLine();
		String name = firstName + " " + lastName;

		// Enter address of student/employee
		System.out.print("Enter " + name + "'s address: ");
		String address = input.nextLine();

		// Enter phone number of student/employee
		System.out.print("Enter " + name + "'s phone number: ");
		String phoneNumber = input.nextLine();

		// Enter email address of student/employee
		System.out.print("Enter " + name + "'s email: ");
		String email = input.next();

		/*
		 * If the user chose to create a student, also prompt and enter for the
		 * student's status
		 */
		if (choice == 1) {

			System.out.print("Enter " + name + "'s class Status: ");
			String status = input.next();

			// Pass arguments from user input to Student constructor
			Student student = new Student(name, address, phoneNumber, email, status);

			// Display message from Student's toString method
			System.out.println("\n" + student);

			/*
			 * If the user chose to create a student, choose whether to create a faculty or
			 * staff
			 */
		} else if (choice == 2) {

			System.out.println("1) To create a Faculty member");
			System.out.println("2) To create an Staff member");
			System.out.print("Choice: ");
			int choiceEmployee = input.nextInt();

			// Prompt and enter the office number of faculty/staff
			System.out.print("Enter an office number: ");
			int officeNumber = input.nextInt();

			// Prompt and enter the salary of faculty/staff
			System.out.print("Enter a salary: $");
			int salary = input.nextInt();

			// Prompt and enter the hire date of faculty/staff
			System.out.print("Enter a hire date (mm/dd/yyyy): ");
			String hireDate = input.next();

			/*
			 * If the user chose to create a faculty, also prompt and enter for the
			 * faculty's office hours and rank
			 */
			if (choiceEmployee == 1) {

				System.out.print("Enter office hours: ");
				String officeHours = input.next();
				String officeHours1 = input.nextLine();
				officeHours += " " + officeHours1;
				
				System.out.print("Enter a rank: ");
				String rank = input.nextLine();

				// Pass arguments from user input to Faculty constructor
				Faculty faculty = new Faculty(name, address, phoneNumber, email, officeNumber, salary, hireDate,
						officeHours, rank);

				// Display message from Faculty's toString method
				System.out.println("\n" + faculty);

				/*
				 * If the user chose to create a staff, also prompt and enter for the staff's
				 * title
				 */
			} else if (choiceEmployee == 2) {

				System.out.print("Enter a title: ");
				String title = input.next();
				String title1 = input.nextLine();
				title += " " + title1;
				

				// Pass arguments from user input to Staff constructor
				Staff staff = new Staff(name, address, phoneNumber, email, officeNumber, salary, hireDate, title);

				// Display message from Staff's toString method
				System.out.println("\n" + staff);
			}

		}

		// Close Scanner input
		input.close();
	}
}

class Person {
	// Declare protected data fields (only accessible by subclasses)
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String email;

	// Create Person constructor that assigns values to data fields from user input
	Person(String name, String address, String phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/*
	 * Create getters that return the value of data fields in the current class so
	 * that subclasses can access these values
	 */
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	/*
	 * This toString method is the string representation of the Person object If the
	 * reference object for Person class is displayed, there will be a certain
	 * message
	 */
	@Override
	public String toString() {
		return "Person: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail Address: "
				+ email;
	}

}

class Student extends Person {
	// Declare protected data fields (only accessible by subclasses)
	protected final String STATUS;

	// Create Student constructor that assigns values to data fields from user input
	Student(String name, String address, String phoneNumber, String email, String status) {
		/*
		 * Since a subclass cannot access its superclass's constructor implicitly, the
		 * super keyword is needed to perform that action
		 */
		super(name, address, phoneNumber, email);
		this.STATUS = status;
	}

	/*
	 * Create getters that return the value of data fields in the current class so
	 * that subclasses can access these values
	 */
	public String getSTATUS() {
		return STATUS;
	}

	/*
	 * This toString method is the string representation of the Student object If
	 * the reference object for Student class is displayed, there will be a certain
	 * message
	 */
	@Override
	public String toString() {
		return "Student: " + getName() + "\nStatus: " + STATUS + "\nAddress: " + getAddress() + "\nPhone Number: "
				+ getPhoneNumber() + "\nEmail Address: " + getEmail();
	}

}

class Employee extends Person {
	// Declare protected data fields (only accessible by subclasses)
	protected int office;
	protected int salary;
	protected String hiredDate;

	// Create Employee constructor that assigns values to data fields from user
	// input
	Employee(String name, String address, String phoneNumber, String email, int office, int salary, String hiredDate) {
		/*
		 * Since a subclass cannot access its superclass's constructor implicitly, the
		 * super keyword is needed to perform that action
		 */
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.hiredDate = hiredDate;
	}

	/*
	 * Create getters that return the value of data fields in the current class so
	 * that subclasses can access these values
	 */
	public int getOffice() {
		return office;
	}

	public int getSalary() {
		return salary;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	/*
	 * This toString method is the string representation of the Employee object If
	 * the reference object for Employee class is displayed, there will be a certain
	 * message
	 */
	@Override
	public String toString() {
		return "Employee: " + getName();
	}

}

class Faculty extends Employee {
	// Declare protected data fields (only accessible by subclasses)
	protected String officeHours;
	protected String rank;

	// Create Faculty constructor that assigns values to data fields from user input
	Faculty(String name, String address, String phoneNumber, String email, int office, int salary, String hiredDate,
			String officeHours, String rank) {
		/*
		 * Since a subclass cannot access its superclass's constructor implicitly, the
		 * super keyword is needed to perform that action
		 */
		super(name, address, phoneNumber, email, office, salary, hiredDate);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	/*
	 * Create getters that return the value of data fields in the current class so
	 * that subclasses can access these values
	 */
	public String getOfficeHours() {
		return officeHours;
	}

	public String getRank() {
		return rank;
	}

	/*
	 * This toString method is the string representation of the Faculty object If
	 * the reference object for Faculty class is displayed, there will be a certain
	 * message
	 */
	@Override
	public String toString() {
		return "Faculty: " + getName() + "\nRank: " + rank + "\nSalary: " + getSalary() + "\nDate Hired: "
				+ getHiredDate() + "\nOffice Hours: " + officeHours + "\nOffice: " + getOffice() + "\nAddress: "
				+ getAddress() + "\nPhone Number: " + getPhoneNumber() + "\nEmail Address: " + getEmail();
	}

}

class Staff extends Employee {
	// Declare protected data fields (only accessible by subclasses)
	protected String title;

	// Create Staff constructor that assigns values to data fields from user input
	Staff(String name, String address, String phoneNumber, String email, int office, int salary, String hiredDate,
			String title) {
		/*
		 * Since a subclass cannot access its superclass's constructor implicitly, the
		 * super keyword is needed to perform that action
		 */
		super(name, address, phoneNumber, email, office, salary, hiredDate);
		this.title = title;
	}

	/*
	 * Create getters that return the value of data fields in the current class so
	 * that subclasses can access these values
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * This toString method is the string representation of the Staff object If the
	 * reference object for Staff class is displayed, there will be a certain
	 * message
	 */
	@Override
	public String toString() {
		return "Staff: " + getName() + "\nTitle: " + title + "\nSalary: " + getSalary() + "\nDate Hired: "
				+ getHiredDate() + "\nOffice: " + getOffice() + "\nAddress: " + getAddress() + "\nPhone Number: "
				+ getPhoneNumber() + "\nEmail Address: " + getEmail();
	}

}