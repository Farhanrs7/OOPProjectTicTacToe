package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	public String name;
	public String shapeCode;
	public ArrayList<double[]> shapePos;
	public Box chosenBox;
	public boolean hasWon;
	
	public Player() {
		shapePos = new ArrayList<double[]>();
	}
	
	public void reset() {
		hasWon = false;
		shapePos = new ArrayList<double[]>();
	}

	public void clickBox() {
	}
	public void putShape(Box box) {
		box.setShape(this.shapeCode);
	}

	public void printShapePos() {
		for(double i[]:this.shapePos) {
			System.out.print("(");
			for (double j:i) {
				System.out.print(j);
				System.out.print(" ,");
			}
			System.out.print(")");
		}
		System.out.println();
	}

}
