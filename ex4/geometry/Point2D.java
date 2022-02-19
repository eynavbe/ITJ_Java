
package ex4.geometry;
/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex4: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point2D implements GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    private double _x,_y;
    //constructor
    public Point2D(double x,double y) {
    	_x=x; _y=y;
    }
    //constructor
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    }
    public Point2D() {
    	_x=0;
    	_y=0;
	}
    public Point2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    public double x() {return _x;}
    public double y() {return _y;}
 
    public int ix() {return (int)_x;}
    public int iy() {return (int)_y;}
    public void setX(double x) {
		this._x= x;
	}

	public void setY(double y) {
		this._y= y;
	}

    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
  

    public double distance()
    {
        return this.distance(ORIGIN);
    }
    public double distance(Point2D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        if(t < 0) {
        	return 0;
        }
        return Math.sqrt(t);
    }

    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point2D p2, double eps)
    {
        return ( this.distance(p2) < eps );
    }
    public boolean close2equals(Point2D p2)
    {
        return close2equals(p2, EPS);
    }
    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return
     */
    public Point2D vector(Point2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point2D(dx,dy);
    }
	@Override
	//Computes if the point (ot) falls inside this (closed) shape
//	public boolean contains(Point2D ot) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}


	@Override
	//Computes the center of mass of this shape
	public Point2D centerOfMass() {
		return new Point2D(this);
	}
	@Override
	//Computes the area of this shape
	public double area() {
		return 0;
	}
	@Override
	//Computes the perimeter of this shape,
	public double perimeter() {
		return 0;
	}
	@Override
	//Moves this shape by the vector
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}
	@Override
	//This method computes a new (deep) copy of this GeoShape
	public GeoShape copy() {
		return new Point2D(this);
	}
	//This method return shape from string
	public Point2D stringToGeoShape(String pointString,String name) {
		String d = pointString.substring(name.length()+1);
        String [] infoPI = d.split(",");
        Point2D p1 = null;
        try {
             p1 = new Point2D(Double.valueOf(infoPI[0]),Double.valueOf(infoPI[1]));
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		return p1;
	}
	  @Override
    //This method returns a String representing this shape
    public String toString()
    {
        return _x+","+_y;
    }
	@Override
	//This method return the dominant point of the shape
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] =new Point2D(this);
		return ans;
	}
}
