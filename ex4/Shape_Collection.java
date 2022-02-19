package ex4;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
//	private final int min = 5;
//	private GUI_Shape[] array = new GUI_Shape[min];
	private ArrayList<GUI_Shape> array = new ArrayList<GUI_Shape>();
	private int size;
	//constructor
	public Shape_Collection(ArrayList<GUI_Shape> array,int size) {
		this.array = array;
		this.size = size;
	}
	//constructor
	public Shape_Collection() {
		this.array =  new ArrayList<GUI_Shape>();
		this.size = 0;
	}
	//This method return a reference to the i'th element in the collection.
	@Override
	public GUI_Shape get(int i) {
		try {
			return array.get(i);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			return null;
		}
	}
	//return the size of the collection (if empty return 0).
	@Override
	public int size() {
		return this.size;
	}
	
	public ArrayList<GUI_Shape> getArray() {
		return this.array;
	}
	// This method remove (and return) the gui_shape at the i'th location.
	 // After removing the size of this collection decreases (by 1) and the order (of the elements) remains the same - just with out the removed element.
	//i the index of the element to be removed.
	 //return the gui_shape which was removed
	@Override
	public GUI_Shape removeElementAt(int i) {
		GUI_Shape g = null;
		try {
			g = array.get(i);
			array.remove(i);
			size =array.size();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		return g;
	}
	//This method adds the gui_element s to this collection in the i'th position.
	@Override
	public void addAt(GUI_Shape s, int i) {
		try {
			array.add(i, s);
			size=array.size();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
	// This method adds the gui_element s to this collection in the last position.
	@Override
	public void add(GUI_Shape s) {
		array.add(s);
		size=array.size();
	}
	// This method constructs a deep copy of this collection.
	@Override
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(array, size);

	}
	//This method sorts this gui_shape collection according to the comp Comparator - in increasing order.
	@Override
	public void sort(Comparator comp) {
		array.sort(comp);
	}
	// This method simple removes all the elements from this collection.
	@Override
	public void removeAll() {
		array.removeAll(array);
		size =array.size();
	}
	// This method saves this gui_shape collection to a text file.
	//file_name the file name in which this collection will be saved.
	@Override
	public void save(String file) {
		 try {
		      FileWriter myWriter = new FileWriter(file);
		      for (GUI_Shape gui_Shape : array) {
				  myWriter.write(gui_Shape.toString() +"\n");
		      }
		      myWriter.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
			
	}
	
	
	//This method restore a gui_shape collection from text file (as saved be the save method).
	@Override
	public void load(String file) {
		try {
		      File myObj = new File(file);
		      Scanner myReader = new Scanner(myObj);
		      removeAll();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String gWord= "GUIShape";
		        int indexGWord = data.indexOf(gWord);
		        if(indexGWord >-1) {
		        
			        GUI_Shape g = new GUIShape().stringToGeoShape(data);
			        array.add(g);
		        }
		      }
		      myReader.close();
		        size = array.size();
		    } catch (FileNotFoundException e) {
		      System.out.println(e);
		    }
	}
	// This methods returns the minimal bounding box containing all the shapes in this collection.
	 
	@Override
	public Rect2D getBoundingBox() {
		 ArrayList<Double> listX = new ArrayList<Double>();
		 ArrayList<Double> listY = new ArrayList<Double>();
		 Rect2D re = new Rect2D();
		for (int i = 0; i < array.size(); i++) {
			GUI_Shape array_element = array.get(i);
			if(array_element.getShape() instanceof Circle2D) {
				Circle2D c =(Circle2D) array_element.getShape();
				double radius = c.getRadius();
				Point2D centerCircle = c.getCenter();
				double d1 = centerCircle.x()+radius;
				listX.add(d1);
				double d = centerCircle.x() - radius;
				listX.add(d);
				double d2 = centerCircle.y()+radius;
				listY.add(d2);
				double d3 = centerCircle.y()-radius;
				listY.add(d3);
			}else {
				Point2D [] points = array_element.getShape().getPoints();
				for (int j = 0; j < points.length; j++) {
					listX.add(points[j].x());
					listY.add(points[j].y());
				}
			}
			
		}
		
		if((listX.size()>0) && (listY.size()>0)) {
			Collections.sort(listX);
			Collections.sort(listY);
			Point2D p1 = new Point2D(listX.get(listX.size()-1),listY.get(listY.size()-1));
			Point2D p2 = new Point2D(listX.get(0),listY.get(0));
			re = new Rect2D(p2,p1);
		}
		return re;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += array.toString();
		s += "size: "+size;
		return s;
	}
	
	
}
