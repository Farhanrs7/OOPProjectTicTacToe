package application;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class BoxList {
	public int numberOfBoxes = 9;
	public ArrayList<Box> list;
	public BoxList(){
	}
	public BoxList(AnchorPane board){
		list = new ArrayList<Box>();
		for(int i=1;i<=numberOfBoxes;i++) {
			String id = "#box" + Integer.toString(i);
			Box tempBox = new Box();
			tempBox.rect = (Rectangle) board.getScene().lookup(id);
			list.add(tempBox);
		}
		String idCircle;
		String idLine1;
		String idLine2;
		for(int i=1;i<=numberOfBoxes;i++) {
			idCircle = "#circle"+Integer.toString(i);
			idLine1 ="#x"+Integer.toString(i)+"1";
			idLine2 = "#x"+Integer.toString(i)+"2";
			list.get(i-1).oshape.circle= (Circle) board.getScene().lookup(idCircle);
			list.get(i-1).xshape.line1= (Line) board.getScene().lookup(idLine1);
			list.get(i-1).xshape.line2= (Line) board.getScene().lookup(idLine2);
		}
	}
	public void clearAll() {
		for(Box i:list) {
			i.rect.setVisible(false);
			i.oshape.setVisibility(false);
			i.xshape.setVisibility(false);
		}
	}
	public Box getById(String id) {
		for(Box i:list) {
			if (i.rect.getId()==id) {
				return i;
			}
		}
		return null;
	}
	public void unhighlightAll() {
		for(Box i:list) {
			if(i.highlighted) {
				i.highlight();
			}
		}
	}
	
	
}
