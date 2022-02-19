package ex4;
import ex4.geometry.*;
import java.awt.Color;
import java.util.Scanner;

import ex4.Ex4;
import ex4.Ex4_Const;
import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.StdDraw;

public class Ex4Main {

	private static void create(int sortNum, String file) {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
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
		Rect2D bb = sc.getBoundingBox();
		GUI_Shape s7 = new GUIShape(bb,false, Color.gray, tag++);
		sc.add(s7);
		Shape_Comp comp = new Shape_Comp(sortNum);
		win.getShape_Collection().sort(comp);
		sc.save(file);
		sc.removeAll();
		sc.load(file);
		String type;
		
		switch (sortNum) {
		case 0:
			type = "Tag";
			break;
		case 1:
			type = "Anti_Tag";
			break;
		case 2:
			type = "Area";
			break;
		case 3:
			type = "Anti_Area";
			break;
		case 4:
			type = "Perimeter";
			break;
		case 5:
			type = "Anti_Perimeter";
			break;
		case 6:
			type = "toString";
			break;
		default:
			type = "";
			break;
		}
		System.out.println("Shape Collection Sorted by "+type);
		System.out.println(sc.toString());
		win.show();
		
	}
	public static void main(String[] args) {
		if(args.length==2){
			int sortNum = 0;
			String file ="abc.txt";
			for (String b : args) {
				if(b.length() == 1) {
					int index= b.charAt(0);
					if((index >= 49) && (index <= 54)) {
						sortNum = Integer.valueOf(b);                 
					}
				}else{
					file = b;
					if(!file.contains(".")) {
						file+=".txt";
					}
				}
			}
			System.out.println("file: " + file + ", sortNum:" + sortNum);
			create(sortNum,file);
		}
		else{
			Scanner sc1 = new Scanner(System.in);//create Scanner 
			System.out.println("Enter name file: ");
			String file = sc1.next();
			if(!file.contains(".")) {
				file+=".txt";
			}
			System.out.println("Enter sort num 0-6: ");
			int sortNum = sc1.nextInt();  
			if(sortNum >6) {
				System.out.println("sortNum : No number between 0 and 6");
			}else {
				System.out.println("file: " + file + ", sortNum:" + sortNum);
				create(sortNum,file);
				sc1.close();//close Scanner
			}
			
		}

	}

	

}
