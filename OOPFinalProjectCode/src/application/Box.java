package application;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box {
	public Rectangle rect;
	public XShape xshape;
	public OShape oshape;
	public boolean hasShape;
	public boolean highlighted;

	public Box() {
		xshape = new XShape();
		oshape = new OShape();
	}
	public void highlight() {
		if(!highlighted) {
			rect.setStroke(Color.RED);
			highlighted = true;
		}
		else {
			rect.setStroke(Color.BLACK);
			highlighted = false;
		}
	}
	public void clear() {
	}
	public void setShape(String key) {
		if (key.equalsIgnoreCase("o")){
			this.oshape.setVisibility(true);
			this.hasShape=true;
		}
		if (key.equalsIgnoreCase("x")){
			this.xshape.setVisibility(true);
			this.hasShape=true;
		}
	}
}
