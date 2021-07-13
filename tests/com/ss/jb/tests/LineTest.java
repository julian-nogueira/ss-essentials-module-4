package com.ss.jb.tests;

import com.ss.jb.four.Line;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LineTest {
	
	Line line1 = new Line(1, 1, 2, 2);
	Line line2 = new Line(3, 3, 5, 5);

	@Test
	public void getSlope() {
		// x0 = 1, y0 = 1; x1 = 2, y1 = 2. Return 1.
		assertEquals(1, line1.getSlope(), 0.0001);
		assertNotEquals(2, line1.getSlope(), 0.0001);
	}

	@Test
	public void getDistance() {
		// x0 = 1, y0 = 1; x1 = 2, y1 = 2. Return sqrt(2).
		assertEquals(Math.sqrt(2), line1.getDistance(), 0.0001);
		assertNotEquals(2, line1.getDistance(), 0.0001);
	}

	@Test
	public void parallelTo() {
		// x0 = 1, y0 = 1; x1 = 2, y1 = 2. x0 = 3, y0 = 3; x1 = 5, y1 = 5.
		// Return true.
		assertEquals(true, line1.parallelTo(line2));
		assertNotEquals(false, line1.parallelTo(line2));
	}
}
