package application;

import javafx.scene.shape.Line;

public class XShape extends Shape {
	public Line line1;
	public Line line2;
	public String shapeCode = "x";
	@Override
	public void setVisibility(boolean arg) {
		line1.setVisible(arg);
		line2.setVisible(arg);
		this.visibility=arg;
	}

}
