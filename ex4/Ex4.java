package ex4;
import java.awt.Color;
import java.util.ArrayList;

import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	GUI_Shape_Collection g;
	public Ex4(GUI_Shape_Collection g) {
		this.g = g;
	}
	public Ex4() {
		this(new Shape_Collection());
		
	}
	@Override
	//This method inits the GUI_Shape_Collection - which will be presented by Ex4
	public void init(GUI_Shape_Collection g) {
		this.g = g;
	}
	//This method returns  GUI_Shape_Collection
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return this.g;
	}
	//This method presents the gui shapes in the gui windows
	@Override
	public void show() {
		Shape_Collection f =(Shape_Collection)g;
		ArrayList <GUI_Shape> array = f.getArray();
		Rect2D bb = f.getBoundingBox();
		Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		StdDraw.setCanvasSize(Ex4_Const.Width, Ex4_Const.Height);
		StdDraw.setScale(m0-0.1,m1+0.1);
		StdDraw.setPenRadius(0.005);
		for (int i = 0; i < array.size(); i++) {
			if(array.get(i).getShape() instanceof Point2D) {
				Point2D c = (Point2D) array.get(i).getShape();
				 StdDraw.setPenColor(array.get(i).getColor());
				 StdDraw.point(c.x(), c.y());
			}
			if(array.get(i).getShape() instanceof Circle2D) {
				Circle2D c = (Circle2D) array.get(i).getShape();
				 StdDraw.setPenColor(array.get(i).getColor());
				 if(array.get(i).isFilled()) {
					 StdDraw.filledCircle(c.getCenter().x(), c.getCenter().y(), c.getRadius());
				 }else {
					StdDraw.circle(c.getCenter().x(), c.getCenter().y(), c.getRadius());
				 }
			}
			if(array.get(i).getShape() instanceof Rect2D) {
				Rect2D c = (Rect2D) array.get(i).getShape();
				 StdDraw.setPenColor(array.get(i).getColor());
				 double halfX = new Segment2D(c.getPoint1(),c.getPoint2()).lengthPointX()/2;
				 double halfY = new Segment2D(c.getPoint1(),c.getPoint2()).lengthPointY()/2;
				 if(array.get(i).isFilled()) {
					 StdDraw.filledRectangle(c.centerOfMass().x(), c.centerOfMass().y(),halfX,halfY);
				 }else {
					 StdDraw.rectangle(c.centerOfMass().x(), c.centerOfMass().y(),halfX,halfY);

				 }		
			}
			if(array.get(i).getShape() instanceof Triangle2D) {
				Triangle2D c = (Triangle2D) array.get(i).getShape();
				 StdDraw.setPenColor(array.get(i).getColor());
				 Point2D[] points = c.getPoints();
				 double[] pointX = new double[3];
				 double[] pointy = new double[3];
				 for (int j = 0; j < points.length; j++) {
					 pointX[j]= points[j].x();
					 pointy[j]= points[j].y();
				}
				 if(array.get(i).isFilled()) {
					 StdDraw.filledPolygon(pointX,pointy);
				 }else {
					 StdDraw.polygon(pointX,pointy);
				 }
			}
			if(array.get(i).getShape() instanceof Segment2D) {
				Segment2D c = (Segment2D) array.get(i).getShape();
				 StdDraw.setPenColor(array.get(i).getColor());
				 Point2D[] points = c.getPoints();
				 double[] pointX = new double[2];
				 double[] pointy = new double[2];
				 for (int j = 0; j < points.length; j++) {
					 pointX[j]= points[j].x();
					 pointy[j]= points[j].y();
				}
				 if(array.get(i).isFilled()) {
					 StdDraw.filledPolygon(pointX,pointy);
				 }else {
					 StdDraw.polygon(pointX,pointy);
				 }
			}
		}
		

	}

	//This method returns a String with all to string of all shapes in the collection
	@Override
	public String getInfo() {
		return g.toString();
	}
}
