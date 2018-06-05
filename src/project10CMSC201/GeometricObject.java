/*
 * Class: CMSC201 
 * Instructor: Ping-Wei Tsai
 * Description: This program contains data fields that hold values of 
 * 	of triangle's color, fullness and date created.
 * Due: 04/15/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Gabriel I. Feliz 
 */

package project10CMSC201;

import java.util.Date;

abstract class GeometricObject {
	/** Declare private data fields **/
	private String color = "white";
	private boolean filled;
	private Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject() {
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean , the get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "Created on " + dateCreated + "\nColor: " + color + " and filled: " + filled;
	}

	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}