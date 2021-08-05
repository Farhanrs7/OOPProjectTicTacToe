package application;

import java.io.IOException;

import javafx.scene.Scene;

public abstract class Pages {
	public Player player1;
	public Player player2;
	
	public abstract Scene run() throws IOException;

}
