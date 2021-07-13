package com.ss.jb.four;

public class Line {
	// Coordinates.
	private double x0, y0, x1, y1;
	
	// Construct a line object with passed coordinates.
	public Line(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	// Calculate the slope of the line.
	public double getSlope() {
		// Avoid division by zero.
		if(x1 == x0) {
			throw new ArithmeticException();
		}
		return (y1 - y0) / (x1 - x0);
	}

	// Calculate the distance of the line.
	public double getDistance() {
		return Math.sqrt(((x1 - x0) * (x1 - x0)) + ((y1 - y0) * (y1 - y0)));
	}

	// Return whether a line is parallel to another.
	public boolean parallelTo(Line l) {
		// If the difference between the slopes is very small, consider them parallel.
		if(Math.abs(getSlope() - l.getSlope()) < .0001) {
			return true;
		} else {
			return false;
		}
	}
}
