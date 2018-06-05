/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program contains data fields that hold values of 
 * 	of triangle's sides and methods that return the area and perimeter of triangle.
 * Due: 04/15/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project10CMSC201;

public class Triangle extends GeometricObject {
	/** Declare private data fields **/
	private double side1, side2, side3;

	/** Construct a default triangle object */
	Triangle() {
		side1 = side2 = side3 = 1.0;
	}

	/** Construct a triangle object with sides value */
	Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	/** Construct a triangle object with sides, color, filled values */
	Triangle(double side1, double side2, double side3, 
			String color, boolean filled) {
		super(color, filled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	/** Return side 1 */
	public double getSide1() {
		return side1;
	}

	/** Return side 2 */
	public double getSide2() {
		return side2;
	}

	/** Return side 3 */
	public double getSide3() {
		return side3;
	}

	
	@Override
	public String toString() {
		return "Area: " + getArea() + "\nPerimeter: " + getPerimeter() 
				+ "\nColor: " + getColor() + "\nFilled? " + isFilled();
	}
	
	/**
	 * Return area of triangle and overrides getArea() in GeometricObject
	 */
	@Override
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * ((p - side1) * (p - side2) * (p - side3)));
	}

	/**
	 * Return perimeter of triangle and overrides getPerimeter() in
	 * GeometricObject
	 */
	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
}