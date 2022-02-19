package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2DTest {

	@Test
	void testContains() {
		Point2D p1 = new Point2D(-2.4,9.3);
		Rect2D t3 = new Rect2D(p1,p1);
		Point2D p2 = new Point2D(-1.2,3.3);

		assertTrue(t3.contains(p1));
		assertFalse(t3.contains(p2));

		
	}


	@Test
	void testCenterOfMass() {
		Point2D p1 = new Point2D(-2.4,9.3);
		Point2D p2 = new Point2D(-1.2,3.3);
		Point2D p3 = new Point2D(-1.8,6.3);
		Rect2D r1 = new Rect2D(p1,p2);
		assertEquals(p3, r1.centerOfMass());

		Rect2D t3 = new Rect2D(p1,p1);
		assertEquals(p1, t3.centerOfMass());
	}

	@Test
	void testArea() {
		Point2D p1 = new Point2D(5,6);
		Point2D p2 = new Point2D(2,3);
		assertEquals(4.242640687119285, p1.distance(p2));

		Rect2D r1 = new Rect2D(p1,p2);
		assertEquals(9, r1.area());

		Point2D p3 = new Point2D(5,6);
		Point2D p4 = new Point2D(2,-2);
		Rect2D r2 = new Rect2D(p3,p4);
		assertEquals(24, r2.area());

		Point2D p5 = new Point2D(5,-2);
		Point2D p6 = new Point2D(2,-5);
		Rect2D r3 = new Rect2D(p5,p6);
		assertEquals(9, r3.area());

		 p1 = new Point2D(2,3);
		 p2 = new Point2D(-3,-2);
		 r1 = new Rect2D(p1,p2);
		assertEquals(25, r1.area());

		 p1 = new Point2D(-3,-2);
		 p2 = new Point2D(-6,-5);
		 r1 = new Rect2D(p1,p2);
		assertEquals(9, r1.area());

		p1 = new Point2D(0,0);
		 p2 = new Point2D(-6,-5);
		 r1 = new Rect2D(p1,p2);
			assertEquals(30, r1.area());


		p1 = new Point2D(0,0);
		 p2 = new Point2D(0,0);
		 r1 = new Rect2D(p1,p2);
			assertEquals(0, r1.area());

		p1 = new Point2D(0,4);
		 p2 = new Point2D(6,0);
		 r1 = new Rect2D(p1,p2);
			assertEquals(24, r1.area());

		p1 = new Point2D(0,0);
		 p2 = new Point2D(6,0);
		 r1 = new Rect2D(p1,p2);
			assertEquals(0, r1.area());
		
		 p1 = new Point2D(-2.4,9.3);
		 p2 = new Point2D(-1.2,3.3);
		 r1 = new Rect2D(p1,p2);
			assertEquals(7.2, r1.area());
			
			Rect2D t3 = new Rect2D(p1,p1);
			assertEquals(0, t3.area());
	}

	@Test
	void testPerimeter() {
		Point2D p1 = new Point2D(-2.4,9.3);
		Point2D p2 = new Point2D(-1.2,3.3);
		Rect2D r1 = new Rect2D(p1,p2);
		assertEquals(14.4, r1.perimeter());
		
		
		 p1 = new Point2D(-2.4,9.9);
		 p2 = new Point2D(-1.2,3.3);
		 r1 = new Rect2D(p1,p2);
			assertEquals(15.6, r1.perimeter());
			
			Rect2D t3 = new Rect2D(p1,p1);
			assertEquals(0, t3.perimeter());
	}

	@Test
	void testMove() {
		Point2D p1 = new Point2D(5.3,-2.5);
		
		Point2D p3 = new Point2D(-2.4,9.3);
		Point2D p2 = new Point2D(1.2,-3.3);
		Rect2D r1 = new Rect2D(p3,p2);
		r1.move(p1);
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Rect2D r2 = new Rect2D(p5,p6);
		assertTrue(r1.getPoint1().close2equals(r2.getPoint1()));
		assertTrue(r1.getPoint2().close2equals(r2.getPoint2()));

	}

	@Test
	void testCopy() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Point2D p1 = new Point2D(5.3,-2.5);
		Rect2D r2 = new Rect2D(p5,p6);
		Rect2D r3 = (Rect2D) r2.copy();
		r2.setPoint1(p1);
		assertFalse(r3.equals(r2));

	}

	@Test
	void testGetPoints() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Rect2D r2 = new Rect2D(p5,p6);
		Point2D[] p = new Point2D[2];
		p[0]= p5;
		p[1]= p6;
		assertArrayEquals(p, r2.getPoints());
	}

	@Test
	void testToString() {
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Rect2D r2 = new Rect2D(p5,p6);
		String s = "Rect2D,2.9,6.8,6.5,-5.8";
		assertEquals(s, r2.toString());
	}
	

}
