/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program contains a class with private data fields and methods
 * 	that are manipulated from the TestCircle2D.java through an object
 * Due: 03/18/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project7CMSC201;

public class Circle2D {
	// Declare private data fields
	/* These data fields are initialized in the 
	 * constructor with parameters or in the 
	 * no-arg constructor through an object 
	 * from the TestCircle2D class */
	private double x;
	private double y;
	private double radius;
	
	/* No-arg constructor that initializes the data fields 
	 * with default values */
	public Circle2D() {
		this.x = 0.0;
		this.y = 0.0;
		this.radius = 1.0;
	}
	
	/* Constructor with parameters thact 
	 * initializes the data fields 
	 * with values passed to the created objects 
	 * in TestCircle2D class as arguments */
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/* Return value initialized in data field x
	 * to getX method */
	public double getX() {
		return x;
	}
	
	/* Return value initialized in data field y
	 * to getY method */
	public double getY() {
		return y;
	}

	/* Return value initialized in data 
	 * field radius to getRadius method */
	public double getRadius() {
		return radius;
	}
	
	/* Return area of the circle created as an object */
	public double getArea() {
		return ((Math.PI) * Math.pow(radius, 2));
	}

	/* Return perimeter of the circle created as an object */
	public double getPerimeter() {
		return (2 * (Math.PI) * radius);
	}
	
	/* Return true if the specified point (x, y) 
	 * is inside this circle*/
	public boolean contains(double x, double y) {
		boolean isInsideCircle = 
				Math.sqrt(Math.pow(x - this.x, 2) + 
				Math.pow(y - this.y, 2)) <= radius;
		
		return isInsideCircle;
	}
	
	/* Return true if the specified circle 
	 * is inside this circle*/
	public boolean contains(Circle2D circle) {
		boolean isInsideCircle = 
				((Math.sqrt(Math.pow((this.x - circle.x), 2) 
					+ Math.pow((this.y - circle.y), 2))) 
						+ circle.radius) <= this.radius;
		
		return isInsideCircle;
	}
	
	/* Return true if the specified 
	 * and current circle overlap each other*/
	public boolean overlaps(Circle2D circle) {
		boolean isThereOverlapping = 
				Math.sqrt(Math.pow((this.x - circle.x), 2) 
					+ Math.pow((this.y - circle.y), 2)) 
					<= radius + circle.radius;
		
		return isThereOverlapping;
	}
	
}
