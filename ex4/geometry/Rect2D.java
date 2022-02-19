package ex4.geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	private Point2D _point1;
	private Point2D _point2;
	static final double EPS = 0.0001;

	//constructor
	public Rect2D(Point2D point1, Point2D point2) {
		this._point1 = new Point2D(point1);
		this._point2 = new Point2D(point2);
	}
	//constructor
	public Rect2D() {
		this(new Point2D(), new Point2D(1,1));
	}
	
	//constructor
	public Rect2D(Rect2D r) {
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
	// Computes if the point (ot) falls inside this (closed) shape.
	public boolean contains(Point2D ot) {
		boolean containsX = ot.x() <= _point1.x() && ot.x() >= _point2.x();
		boolean containsY = ot.y() <= _point1.y() && ot.y() >= _point2.y();
		return containsX && containsY;
	}
	@Override
	//Computes the center of mass of this shape. 
	public Point2D centerOfMass() {
		return new Segment2D(this._point1,this._point2).centerOfMass();
	}
	@Override
	// Computes the area of this shape
	public double area() {
		double x = new Segment2D(_point1,_point2).lengthPointX();
		double y = new Segment2D(_point1,_point2).lengthPointY();
		return areaBetween2Segment(x,y);
	}
	
	//to solve the problem of double * double (that there be no number affecting the multiple after the decimal point)
	private double areaBetween2Segment(double x,double y) {
		int divideByDozens = ((String.valueOf(x).length()) - (String.valueOf(x)).indexOf(".") -1 )*10;
		x *= divideByDozens;
		int divideByDozensY = ((String.valueOf(y)).length() - ((String.valueOf(y)).indexOf(".")) -1 )*10;
		y *= divideByDozensY;
		divideByDozens *= divideByDozensY;
		if(divideByDozens == 0) {
			divideByDozens = 1;
		}
		return ((x * y) / divideByDozens);
	}
	@Override
	//Computes the perimeter of this shape
	public double perimeter() {
		double x = new Segment2D(_point1,_point2).lengthPointX();
		double y = new Segment2D(_point1,_point2).lengthPointY();
		return (x + x + y + y);
	}

	@Override
	//Moves this shape by the vector
	public void move(Point2D vec) {
		this._point1.move(vec);
		this._point2.move(vec);
	}
	@Override
	// This method computes a new (deep) copy of this GeoShape
	public GeoShape copy() {
		return new Rect2D(_point1,_point2);
	}
	//This method return shape from string
	public Rect2D stringToGeoShape(String rectString,String name) {
		String d = rectString.substring(name.length()+1);
        String [] infoPI = d.split(",");
        Rect2D p = null;
        try {
        	Point2D p1 = new Point2D(Double.valueOf(infoPI[0]),Double.valueOf(infoPI[1]));
            Point2D p2 = new Point2D(Double.valueOf(infoPI[2]),Double.valueOf(infoPI[3]));
            p = new Rect2D(p1,p2);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
        
		return p;
	}
	@Override
	//This method return the dominant point of the shape
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._point1);
		ans[1] =new Point2D(this._point2);
		return ans;
	}
	@Override
	//This method returns a String representing this shape
	public String toString() {
		 return "Rect2D,"+_point1.toString()+","+_point2.toString();
	}

}
