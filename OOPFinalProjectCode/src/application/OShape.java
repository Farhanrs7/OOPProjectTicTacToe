package application;

import javafx.scene.shape.Circle;

public class OShape extends Shape {
	public Circle circle;
	public String shapeCode = "o";
	@Override
	public void setVisibility(boolean arg) {
		circle.setVisible(arg);
		this.visibility=arg;
		
	}

}
