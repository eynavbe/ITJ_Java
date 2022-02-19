package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;

class GUIShapeTest {

	@Test
	void testGUIShape() {
		Point2D p1 = new Point2D(0.1,0.2);

		Circle2D c1 = new Circle2D(p1,0.14);
		p1.move(p1);
		int tag=0;
		GUI_Shape s1 = new GUIShape();
		assertEquals(Color.pink, s1.getColor());

		s1.setColor(Color.blue);
		assertEquals(Color.blue, s1.getColor());

		s1.setFilled(true);
		assertEquals(true, s1.isFilled());
		s1.setTag(tag++);
		assertEquals(0, s1.getTag());
		Point2D p2 = new Point2D();
		assertEquals(p2, s1.getShape());
		s1.setShape(c1);
		assertEquals(c1, s1.getShape());
		String s= "GUIShape,255,true,0,Circle2D,0.1,0.2,0.14";
		assertEquals(s, s1.toString());

		
	}

}
