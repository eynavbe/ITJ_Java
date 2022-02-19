package ex4.geometry;

import java.awt.Color;

import ex4.Ex4_Const;
import ex4.GUIShape;
import ex4.GUI_Shape;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	private Point2D _point1;
	private Point2D _point2;
	//constructor
	public Segment2D(Point2D point1, Point2D point2) {
		this._point1 = new Point2D(point1);
		this._point2 = new Point2D(point2);
	}
	//constructor
	public Segment2D() {
		this(new Point2D(), new Point2D(1,1));
	}
	//constructor
	public Segment2D(Segment2D r) {
		this(r._point1, r._point2);
	}
	public Point2D getPoint1() {
		return new Point2D(this._point1);
	}
	
	public void setPoint1(Point2D point1) {		
		this._point1 = new Point2D(point1);
	}
	public Point2D getPoint2() {
		return new Point2D(this._point2);
	}
	
	public void setPoint2(Point2D point2) {		
		this._point2 = new Point2D(point2);
	}
	@Override
	//Computes if the point (ot) falls inside this (closed) shape
	public boolean contains(Point2D ot) {
		double distOtToP1 = ot.distance(this._point1);
		double distOtToP2 = ot.distance(this._point2);
		return ((distOtToP1+distOtToP2) == lengthSegment());
	}

	@Override
	//Computes the center of mass of this shape
	public Point2D centerOfMass() {
		double xM = centerOfMassOneCoordinates(this._point1.x(),this._point2.x());
		double yM = centerOfMassOneCoordinates(this._point1.y(),this._point2.y());
		return new Point2D(xM,yM);
	}
	//to solve the problem of double + double/2 (that there be no number affecting the multiple after the decimal point)
	private double centerOfMassOneCoordinates(double x1,double x2) {
		int divideByDozens = ((String.valueOf(x1).length()) - (String.valueOf(x1)).indexOf(".") -1 )*10;
		x1 *= divideByDozens;
		int divideByDozensY = ((String.valueOf(x2)).length() - ((String.valueOf(x2)).indexOf(".")) -1 )*10;
		x2 *= divideByDozensY;
		if(divideByDozens > divideByDozensY) {
			x2 *=  (divideByDozens / divideByDozensY);
		}else {
			if(divideByDozens < divideByDozensY) {
				x1 *=  (divideByDozensY / divideByDozens);
				divideByDozens = divideByDozensY;
			}
		}
		if(divideByDozens == 0) {
			divideByDozens = 1;
		}
		return (((x1 + x2)/2) / divideByDozens);
	}
	//length Point X
	public double lengthPointX() {
		return (lengthBetween2Segment(this._point1.x(),this._point2.x()));

	}
	//length Point Y
	public double lengthPointY() {
		return (lengthBetween2Segment(this._point1.y(),this._point2.y()));
	}
	//to solve the problem of double - double (that there be no number affecting the multiple after the decimal point)
	private double lengthBetween2Segment(double x1,double x2) {
		int divideByDozens = ((String.valueOf(x1).length()) - (String.valueOf(x1)).indexOf(".") -1 )*10;
		x1 *= divideByDozens;
		int divideByDozensY = ((String.valueOf(x2)).length() - ((String.valueOf(x2)).indexOf(".")) -1 )*10;
		x2 *= divideByDozensY;
		if(divideByDozens > divideByDozensY) {
			x2 *=  (divideByDozens / divideByDozensY);
		}else {
			if(divideByDozens < divideByDozensY) {
				x1 *=  (divideByDozensY / divideByDozens);
				divideByDozens = divideByDozensY;
			}
		}
		if(divideByDozens == 0) {
			divideByDozens = 1;
		}
		return ((Math.abs(x1-x2))/divideByDozens);
	}
	// length Segment
	public double lengthSegment() {
		return (Math.sqrt((lengthPointX()*lengthPointX() + lengthPointY()*lengthPointY())));

	}
	//Computes the area of this shape
	@Override
	public double area() {
		return 0;
	}

	@Override
	//Computes the perimeter of this shape
	public double perimeter() {
		return (lengthSegment())*2;
	}

	@Override
	//Moves this shape by the vector
	public void move(Point2D vec) {
		this._point1.move(vec);
		this._point2.move(vec);
	}

	@Override
	//This method computes a new (deep) copy of this GeoShape
	public GeoShape copy() {
		return new Segment2D(_point1,_point2);
	}
	//This method return shape from string
	public Segment2D stringToGeoShape(String segmentString,String name) {
		String d = segmentString.substring(name.length()+1);
        String [] infoPI = d.split(",");
        Segment2D p = null;
        try {
        	 Point2D p1 = new Point2D(Double.valueOf(infoPI[0]),Double.valueOf(infoPI[1]));
             Point2D p2 = new Point2D(Double.valueOf(infoPI[2]),Double.valueOf(infoPI[3]));
              p = new Segment2D(p1,p2);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
       
		return p;
	}
	@Override
	// This method return the dominant point of the shape
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._point1);
		ans[1] =new Point2D(this._point2);
		return ans;
	}
	@Override
	//This method returns a String representing this shape
	public String toString() {
//		 return _point1.toString()+", "+_point2.toString();
		 return "Segment2D,"+_point1.toString()+","+_point2.toString();

	}
}