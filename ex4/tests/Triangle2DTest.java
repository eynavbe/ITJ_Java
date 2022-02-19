package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Triangle2DTest {
	Point2D p1 = new Point2D(6.4,3.1);
	Point2D p2 = new Point2D(4.8,0.85);
	Point2D p3 = new Point2D(3.2,-1.4);
	Point2D p4 = new Point2D(5.4,-2.98);
	 Triangle2D t1 = new Triangle2D(p1,p2,p3);
	 Triangle2D t2 = new Triangle2D(p1,p3,p4);
		static final double EPS = 0.0001;

		

	
	@Test
	void testContains() {
		Point2D p5 = new Point2D(1,3);
		Point2D p6 = new Point2D(-2,5);
		
		Point2D p10 = new Point2D(3.2,7);
		Point2D p7 = new Point2D(3.2,7);
		Point2D p8 = new Point2D(8,1.3);
		Point2D p9 = new Point2D(-2.5,1);
		 Triangle2D t3 = new Triangle2D(p7,p9,p8);

		assertTrue(t3.contains(p5));
		assertFalse(t3.contains(p6));
		assertTrue(t3.contains(p10));

	}


	@Test
	void testCenterOfMass() {
		assertEquals(p2, t1.centerOfMass());
		
		Point2D p11 = new Point2D(15,15);
		Point2D p12 = new Point2D(24,15);
		Point2D p14 = new Point2D(66,15);
		Point2D p15 = new Point2D(35,15);

		 Triangle2D t3 = new Triangle2D(p12,p11,p14);
			assertEquals(p15, t3.centerOfMass());

	}

	@Test
	void testArea() {
		assertEquals(0, t1.area());
		assertEquals(7.478, t2.area(),EPS);
		

	}

	@Test
	void testPerimeter() {
			assertEquals(11.04355015382282, t1.perimeter());
			Point2D p1 = new Point2D(6.4,3.1);
			Point2D p3 = new Point2D(3.2,-1.4);
			Point2D p4 = new Point2D(5.4,-2.98);
			Triangle2D t2 = new Triangle2D(p1,p3,p4);
			assertEquals(14.392, t2.perimeter(),EPS);
			
			
			Triangle2D t3 = new Triangle2D(p1,p1,p1);
			assertEquals(0, t3.perimeter());

	}

	@Test
	void testMove() {
		
		Point2D p3 = new Point2D(-2.4,9.3);
		Point2D p2 = new Point2D(1.2,-3.3);
		Point2D p1 = new Point2D(5.4,-2.98);
//		Point2D p8 = new Point2D(5.4,-2.98);
		Point2D p8 = new Point2D(5.3,-2.5);

		Triangle2D r1 = new Triangle2D(p3,p2,p1);
		r1.move(p8);
		Point2D p5 = new Point2D(2.9,6.8);
		Point2D p6 = new Point2D(6.5,-5.8);
		Point2D p7 = new Point2D(10.7,-5.48);
System.out.println("r1 "+r1);
		Triangle2D r2 = new Triangle2D(p5,p6,p7);
		assertTrue(r1.getPoint1().close2equals(r2.getPoint1()));
		assertTrue(r1.getPoint2().close2equals(r2.getPoint2()));
		assertTrue(r1.getPoint3().close2equals(r2.getPoint3()));

	}

	@Test
	void testCopy() {
		Point2D p7 = new Point2D(3.2,7);
		Point2D p8 = new Point2D(8,1.3);
		Point2D p9 = new Point2D(-2.5,1);
		 Triangle2D t3 = new Triangle2D(p7,p9,p8);
		Point2D p1 = new Point2D(5.3,-2.5);
		Triangle2D t2 = (Triangle2D) t3.copy();
		t3.setPoint1(p1);
		assertFalse(t2.equals(t3));
	}

	@Test
	void testGetPoints() {
		Point2D p7 = new Point2D(3.2,7);
		Point2D p8 = new Point2D(8,1.3);
		Point2D p9 = new Point2D(-2.5,1);
		 Triangle2D t3 = new Triangle2D(p7,p8,p9);
		 Point2D[] p = new Point2D[3];
			p[0]= p7;
			p[1]= p8;
			p[2]= p9;

			assertArrayEquals(p, t3.getPoints());
	}

	@Test
	void testToString() {
		Point2D p7 = new Point2D(3.2,7);
		Point2D p8 = new Point2D(8,1.3);
		Point2D p9 = new Point2D(-2.5,1);
		 Triangle2D t3 = new Triangle2D(p7,p8,p9);
		 String s = "Triangle2D,3.2,7.0,8.0,1.3,-2.5,1.0";
			assertEquals(s, t3.toString());
	}
	

}
