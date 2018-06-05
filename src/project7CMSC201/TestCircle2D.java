/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program uses objects to calculate and display
 * 	results of different circles
 * Due: 03/18/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project7CMSC201;

public class TestCircle2D {

	public static void main(String[] args) {
		
		/* Create circle one with center coordinate of (2, 2)
		 * and radius of 5.5 */
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		
		/* Create circle two with center coordinate of (4, 5)
		 * and radius of 10.5 */
		Circle2D c2 = new Circle2D(4, 5, 10.5);
		
		/* Create circle three with center coordinate of (3, 5)
		 * and radius of 2.3 */
		Circle2D c3 = new Circle2D(3, 5, 2.3);
		
		// Display area and perimeter of first circle
		System.out.println("The area of circle one is " + c1.getArea() 
				+ " and its perimeter is " + c1.getPerimeter() );
		
		// Display whether point (3, 3) is inside of the first circle
		System.out.println("The claim that the point (3, 3) is inside of "
				+ "circle one is " + c1.contains(3, 3) ); 
		
		// Display whether second circle is inside of the first circle
		System.out.println("The claim that circle two is inside of "
				+ "circle one is " + c1.contains(c2) ); 
		
		// 18.	Display whether third circle overlaps the first circle
		System.out.println("The claim that circle three overlaps "
				+ "circle one is " + c1.overlaps(c3)); 
		
	}
}
