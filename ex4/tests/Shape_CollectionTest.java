package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.Ex4_Const;
import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {

	@Test
	void test() {
		Shape_Collection sc = new Shape_Collection();
		Point2D p1 = new Point2D(0.1,0.2);
		
		Circle2D c1 = new Circle2D(p1,0.14);
		Rect2D r1 = new Rect2D(p1, new Point2D(0.5,0.45));
		Rect2D r2 = new Rect2D(p1, new Point2D(0.17,0.77));
		Point2D a1 = new Point2D(0.8,0.7), a2 = new Point2D(0.3,0.65), a3 = new Point2D(0.1,0.1);;
		Triangle2D t1 = new Triangle2D(a1,a2,a3);
		p1.move(p1);
		Segment2D seg1 = new Segment2D(new Point2D(0.2,0.6), new Point2D(0.7,0.2));
		int tag = 0;
		GUI_Shape s1 = new GUIShape(p1,false, Color.blue, tag++);
		GUI_Shape s2 = new GUIShape(c1,true, Color.red, tag++);
		GUI_Shape s3 = new GUIShape(r1,true, Color.green, tag++);
		GUI_Shape s4 = new GUIShape(r2,false, Color.cyan, tag++);
		GUI_Shape s5 = new GUIShape(t1,false, Color.orange, tag++);
		GUI_Shape s6 = new GUIShape(seg1,false, Color.pink, tag++);
		sc.add(s1);
		sc.add(s2);
		sc.add(s3);
		sc.add(s4);
		sc.add(s5);
		sc.add(s6);
		System.out.println(sc);
		sc.save("test_save.txt");
		sc.add(s1);
		sc.add(s2);
		assertEquals(8, sc.size());
		Shape_Collection sc2 = (Shape_Collection) sc.copy();
		GUI_Shape s8 = sc.removeElementAt(1);
		assertEquals(s8, s2);
		
		sc.addAt(s8, 1);
		assertEquals(sc2.size(),sc.size());
		assertEquals(sc2.getArray(), sc.getArray());
		sc.load("test_save.txt");
		
		
		
		sc.save("test_save.txt");
		Shape_Collection sc1 = (Shape_Collection) sc.copy();
		sc.removeAll();
		sc.load("test_save.txt");
		assertEquals(sc.getArray(),sc1.getArray());
		assertEquals(sc.size(),sc1.size());

		
		
		
		assertEquals(Color.blue, sc.getArray().get(0).getColor());

		assertEquals(6, sc.size());
		Point2D pr1 = new Point2D(0.8,0.77);
		Point2D pr2 = new Point2D(0.1,0.1);
		Rect2D rb1=new Rect2D(pr1,pr2);
		Rect2D rb2= sc.getBoundingBox();

		Shape_Comp d = new Shape_Comp(Ex4_Const.Sort_By_Area);
		sc.sort(d);
		sc.removeAll();
		assertEquals(0, sc.size());

	}

}
