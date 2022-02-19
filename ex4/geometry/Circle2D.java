package ex4.geometry;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;
	
	//constructor
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		if(rad < 0) {
            System.err.println("ERR: radius must be a positive number ");
            this._radius = 1;
		}else {
			this._radius = rad;
		}
	}
	//constructor
	public Circle2D() {
		this._center = new Point2D();
		this._radius = 1;
	}
	//constructor
	public Circle2D(Circle2D c) {
		this(c._center,c._radius);
	}

	public Point2D getCenter() {
		return new Point2D(this._center);
	}
	
	public void setCenter(Point2D center) {		
		this._center = new Point2D(center);
	}
	
	public void setRadius(double radius) {
		try {
			if(radius < 0) {
	            this._radius = 1;
			     throw new IllegalArgumentException("ERR: radius must be a positive number "); 
			}else {
				this._radius = radius;
			}
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	}
	public double getRadius() {return this._radius;}
	
	@Override
	//Computes if the point (ot) falls inside this (closed) shape
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	@Override
	//Computes the center of mass of this shape. 
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}
	@Override
	//Computes the area of this shape
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
	//Computes the perimeter of this shape
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	@Override
	// Moves this shape by the vector
	public void move(Point2D vec) {
		_center.move(vec);
	}
	@Override
	//This method computes a new (deep) copy of this GeoShape
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}
	//This method return shape from string
		public Circle2D stringToGeoShape(String circleString,String name) {
			String d = circleString.substring(name.length()+1);
	        String [] infoPI = d.split(",");
	        Circle2D p = null;
	        try {
	        	Point2D p1 = new Point2D(Double.valueOf(infoPI[0]),Double.valueOf(infoPI[1]));
		         p = new Circle2D(p1,Double.valueOf(infoPI[2]));
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
			return p;
		}
	 @Override
	 // This method returns a String representing this shape
    public String toString(){
		 return "Circle2D,"+_center.toString()+","+_radius;
	 }
	@Override
	//This method return the dominant point of the shape
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

}
