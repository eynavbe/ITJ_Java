package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import java.util.Scanner;

import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	private GeoShape geoShape;
	private boolean filled;
	private Color color;
	private int tag;
	//constructor
	public GUIShape(GeoShape geoShape,boolean filled,Color color,int tag) {
		this.geoShape = geoShape;
		this.filled = filled;
		this.color = color;
		this.tag = tag;
	}
	//constructor
	public GUIShape() {
		this(new Point2D(),false,Color.pink,-1);
	}
	@Override
	public GeoShape getShape() {
		return this.geoShape;
	}

	@Override
	public void setShape(GeoShape g) {
		this.geoShape = g;
	}

	@Override
	public boolean isFilled() {
		return this.filled;	
		}

	@Override
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public Color getColor() {
		
		return this.color;
	}

	@Override
	public void setColor(Color cl) {
		this.color = cl;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int tag) {
		this.tag = tag;
	}

	@Override
	// This method computes a new (deep) copy of this GUI_Shape
	public GUI_Shape copy() {
		return new GUIShape(geoShape,filled,color,tag);

	}
	//This method return shape from string
	public GUI_Shape stringToGeoShape(String geoShapestring) {
		GUI_Shape g = new GUIShape();
        String gWord= "GUIShape";
    	String data = geoShapestring.substring(gWord.length()+1);
    	int indexPWord = data.indexOf("Point2D");
        int indextriangle2DWord = data.indexOf("Triangle2D");
        int indexsegment2DWord = data.indexOf("Segment2D");
        int indexrect2DWord = data.indexOf("Rect2D");
        int indexcircle2DWord = data.indexOf("Circle2D");
        if(indexPWord >-1) {
        	String infoG = data.substring(0,indexPWord);
	        String d = data.substring(indexPWord);
	        Point2D p= new Point2D().stringToGeoShape(d, "Point2D");
        	String [] infoI = infoG.split(",");
        	try {
    	        g = new GUIShape(p,Boolean.valueOf(infoI[1]),new Color(Integer.valueOf(infoI[0])),Integer.valueOf(infoI[2]));
	   		}catch (ArrayIndexOutOfBoundsException e) {
	   			System.out.println(e);
	   		}
        }
        
        if(indextriangle2DWord >-1) {
        	String infoG = data.substring(0,indextriangle2DWord);
	        String d = data.substring(indextriangle2DWord);
	        Triangle2D p = new Triangle2D().stringToGeoShape(d, "Triangle2D");
	        String [] infoI = infoG.split(",");
	        try {
		         g = new GUIShape(p,Boolean.valueOf(infoI[1]),new Color(Integer.valueOf(infoI[0])),Integer.valueOf(infoI[2]));
	   		}catch (ArrayIndexOutOfBoundsException e) {
	   			System.out.println(e);
	   		}
        }
        if(indexsegment2DWord >-1) {
        	String infoG = data.substring(0,indexsegment2DWord);
	        String d = data.substring(indexsegment2DWord);
	        Segment2D p = new Segment2D().stringToGeoShape(d, "Segment2D");
	        String [] infoI = infoG.split(",");
	         try {
		         g = new GUIShape(p,Boolean.valueOf(infoI[1]),new Color(Integer.valueOf(infoI[0])),Integer.valueOf(infoI[2]));
	   		}catch (ArrayIndexOutOfBoundsException e) {
	   			System.out.println(e);
	   		}
        }
        if(indexrect2DWord >-1) {
        	String infoG = data.substring(0,indexrect2DWord);
	        String d = data.substring(indexrect2DWord);
	        Rect2D p = new Rect2D().stringToGeoShape(d, "Rect2D");
	        String [] infoI = infoG.split(",");
	         try {
		         g = new GUIShape(p,Boolean.valueOf(infoI[1]),new Color(Integer.valueOf(infoI[0])),Integer.valueOf(infoI[2]));
	   		}catch (ArrayIndexOutOfBoundsException e) {
	   			System.out.println(e);
	   		}
        }
        if(indexcircle2DWord >-1) {
        	String infoG = data.substring(0,indexcircle2DWord);
	        String d = data.substring(indexcircle2DWord);
	        Circle2D p = new Circle2D().stringToGeoShape(d, "Circle2D");
	        String [] infoI = infoG.split(",");
	        try {
		        g = new GUIShape(p,Boolean.valueOf(infoI[1]),new Color(Integer.valueOf(infoI[0])),Integer.valueOf(infoI[2]));
	        }catch (ArrayIndexOutOfBoundsException e) {
	   			System.out.println(e);
	   		}
        }
		return g;
	}
	@Override
	public String toString() {
		int c = this.color.getRGB() & 0xffffff;
		String shape = "";
		if(geoShape instanceof Point2D) {
			shape +="Point2D"+",";
		}
		 shape += geoShape.toString();
		 return "GUIShape,"+c+","+this.filled+","+this.tag+","+shape;

	}
}
