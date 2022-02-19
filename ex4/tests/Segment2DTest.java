package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

class Segment2DTest {
	Point2D p1 = new Point2D(6.4,3.1);
	Point2D p3 = new Point2D(3.2,-1.4);
	 Point2D p4 = new Point2D(4.8,0.85);

 Segment2D s1 = new Segment2D(p1,p3);
 Point2D p5 = new Point2D(-2,9);
 Segment2D s2 = new Segment2D(p5,p3);
 Point2D p6 = new Point2D(-0.5,6.5);
	static final double EPS = 0.0001;

	@Test
	void testContains() {
		assertTrue(s1.contains(p4));
		assertFalse(s2.contains(p6));

	}


	@Test
	void testCenterOfMass() {
		assertEquals(p4, s1.centerOfMass());
		
		Point2D p3 = new Point2D(3.2,-1.4);
		Point2D p5 = new Point2D(-2,9);
		Segment2D s2 = new Segment2D(p5,p3);
		 Point2D p6 = new Point2D(0.6,3.8);

		assertEquals(p6,s2.centerOfMass());
	 

	}

	@Test
	void testArea() {
			assertEquals(0, s1.area());
			Segment2D t3 = new Segment2D(p1,p1);
			assertEquals(0, t3.area());
	}

	@Test
	void testPerimeter() {
			assertEquals(11.04355015382282, s1.perimeter());
			Segment2D t3 = new Segment2D(p1,p1);
			assertEquals(0, t3.perimeter());
	}

	@Test
	void testMove() {
Point2D p1 = new Point2D(5.3,-2.5);
		
		Point2D p3 = new Point2D(-2.4,9.3);
		Point2D p2 = new Point2D(1.2,-3.3);
		Segment2D r1 = new Segment2D(p3,p2);
		r1.move(p1);
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Segment2D r2 = new Segment2D(p5,p6);
		assertTrue(r1.getPoint1().close2equals(r2.getPoint1()));
		assertTrue(r1.getPoint2().close2equals(r2.getPoint2()));
	}

	@Test
	void testCopy() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Point2D p1 = new Point2D(5.3,-2.5);
		Segment2D r2 = new Segment2D(p5,p6);
		Segment2D r3 = (Segment2D) r2.copy();
		r2.setPoint1(p1);
		assertFalse(r3.equals(r2));
	}

	@Test
	void testGetPoints() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Segment2D r2 = new Segment2D(p5,p6);
		Point2D[] p = new Point2D[2];
		p[0]= p5;
		p[1]= p6;
		assertArrayEquals(p, r2.getPoints());
	}

	@Test
	void testToString() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Segment2D r2 = new Segment2D(p5,p6);
		String s = "Segment2D,2.9,6.8,6.5,-5.8";
		assertEquals(s, r2.toString());

	}
	

}
