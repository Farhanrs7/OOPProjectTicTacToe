package application;

import java.util.ArrayList;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;

public class Controller {
	
	public Rectangle r = new Rectangle();
	@FXML
	public ArrayList<Rectangle> boxList;
	public ArrayList<Circle> circleList;
	public ArrayList<Line> xList;

 	public void drawShapes(KeyEvent event) {
 		try {
			if(event.getCode()==KeyCode.X && r.getAccessibleHelp().equals("true")) {
				Line l1 = xList.get(Integer.valueOf(r.getAccessibleText())*2);
				Line l2 = xList.get((Integer.valueOf(r.getAccessibleText())*2)+1);
				l1.setVisible(true);
				l2.setVisible(true);
				r.setAccessibleHelp("false");
			}
			else if (event.getCode()==KeyCode.O && r.getAccessibleHelp().equals("true")) {
				Circle c = circleList.get(Integer.valueOf(r.getAccessibleText()));
				c.setVisible(true);
				r.setAccessibleHelp("false");
			}
 		}
 		catch (Exception e){
 		}
	}
	
	public void highlightBox(MouseEvent e) {
		r.setStroke(Color.BLACK);
		r = (Rectangle) e.getSource();
		r.setStroke(Color.RED);
		for(Rectangle test : boxList) {
			if( r == test) {
				r.setAccessibleText(Integer.toString(boxList.indexOf(test)));
			}
		}
	}
}
