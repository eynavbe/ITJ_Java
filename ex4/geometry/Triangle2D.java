package ex4.geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D _point1;
	private Point2D _point2;
	private Point2D _point3;
	
	//constructor
	public Triangle2D(Point2D point1, Point2D point2,Point2D point3) {
		this._point1 = new Point2D(point1);
		this._point2 = new Point2D(point2);
		this._point3 = new Point2D(point3);
	}
	
	//constructor
	public Triangle2D() {
		this(new Point2D(), new Point2D(1,1),new Point2D(2,0));
	}
	//constructor
	public Triangle2D(Triangle2D t) {
		this(t._point1, t._point2,t._point3);
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
	public Point2D getPoint3() {
		return new Point2D(this._point3);
	}
	
	public void setPoint3(Point2D point3) {		
		this._point3 = new Point2D(point3);
	}
	@Override
	//Computes if the point (ot) falls inside this (closed) shape
	public boolean contains(Point2D ot) {
		double area = new Triangle2D(_point1,_point2,_point3).area();
		double area1 = new Triangle2D(ot,_point1,_point2).area();
		double area2 = new Triangle2D(ot,_point1,_point3).area();
		double area3 = new Triangle2D(ot,_point2,_point3).area();
		double sum = (area1+area2+area3);
		//to solve the problem of double * double (that there be no number affecting the multiple after the decimal point)
		//In the case of a lot of 0 after the dot
		String sumS = String.valueOf(sum);
		String areaS = String.valueOf(area);
		//In the case of a lot of 9 after the dot
		 if(!sumS.contains(areaS)) {
			 areaS = areaS.substring(0,areaS.length()-1);
		 }
		return sumS.contains(areaS);
	}
	
	@Override
	//Computes the center of mass of this shape
	public Point2D centerOfMass() {
		double xCenter = center(_point1.x() , _point2.x() , _point3.x());
		double yCenter = center(_point1.y() , _point2.y() , _point3.y());
		return new Point2D(xCenter,yCenter);
	}
	//to solve the problem of double + double (that there be no number affecting the multiple after the decimal point)
	private double center(double z1,double z2,double z3) {
		int divideByDozens = ((String.valueOf(z1).length()) - (String.valueOf(z1)).indexOf(".") -1 )*10;
		z1 *= divideByDozens;
		int divideByDozensZ2 = ((String.valueOf(z2)).length() - ((String.valueOf(z2)).indexOf(".")) -1 )*10;
		z2 *= divideByDozensZ2;
		if(divideByDozensZ2 < divideByDozens) {
			z2 *= divideByDozens/ divideByDozensZ2;
		}else {
			z1 *= divideByDozensZ2/ divideByDozens;
			divideByDozens = divideByDozensZ2;
		}
		int divideByDozensZ3 = ((String.valueOf(z3)).length() - ((String.valueOf(z3)).indexOf(".")) -1 )*10;
		z3 *= divideByDozensZ3;
		if(divideByDozensZ3 < divideByDozens) {
			z3 *= divideByDozens/ divideByDozensZ3;
		}else {
			z1 *= divideByDozensZ3/ divideByDozens;
			z2 *= divideByDozensZ3/ divideByDozens;
			divideByDozens = divideByDozensZ3;
		}
		if(divideByDozens == 0) {
			divideByDozens = 1;
		}
		return (((z1 + z2 + z3) /3)/ divideByDozens);
	}
	@Override
	////Computes the area of this shape
	public double area() {
		double a = new Segment2D(this._point1,this._point2).lengthSegment();
		double b = new Segment2D(this._point2,this._point3).lengthSegment();
		double c = new Segment2D(this._point1,this._point3).lengthSegment();
		double p = perimeter()/2;
		return Math.sqrt(p * (p - a)* (p - b) * (p - c));
	}
	
	@Override
	//Computes the perimeter of this shape
	public double perimeter() {
		double a = new Segment2D(this._point1,this._point2).lengthSegment();
		double b = new Segment2D(this._point2,this._point3).lengthSegment();
		double c = new Segment2D(this._point1,this._point3).lengthSegment();
		return (a + b + c);
	}

	@Override
	//Moves this shape by the vector
	public void move(Point2D vec) {
		this._point1.move(vec);
		this._point2.move(vec);
		this._point3.move(vec);
	}

	@Override
	//This method computes a new (deep) copy of this GeoShape. 
	public GeoShape copy() {
		return new Triangle2D(_point1,_point2,_point3);
	}
	//This method return shape from string
	public Triangle2D stringToGeoShape(String triangleString,String name) {
		String d = triangleString.substring(name.length()+1);
        String [] infoPI = d.split(",");
        Triangle2D p = null;
        try {
        	Point2D p1 = new Point2D(Double.valueOf(infoPI[0]),Double.valueOf(infoPI[1]));
            Point2D p2 = new Point2D(Double.valueOf(infoPI[2]),Double.valueOf(infoPI[3]));
            Point2D p3 = new Point2D(Double.valueOf(infoPI[4]),Double.valueOf(infoPI[5]));
             p = new Triangle2D(p1,p2,p3);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		return p;
	}
	@Override
	//This method return the dominant point of the shape
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] =new Point2D(this._point1);
		ans[1] =new Point2D(this._point2);
		ans[2] =new Point2D(this._point3);
		return ans;
	}
	@Override
	//This method returns a String representing this shape
	public String toString() {
//		 return _point1.toString()+", "+_point2.toString()+", "+_point3.toString();
		 return "Triangle2D,"+_point1.toString()+","+_point2.toString()+","+_point3.toString();

	}
}
