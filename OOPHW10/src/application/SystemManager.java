package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SystemManager extends Application{
	public Player player1;
	public Player player2;
	public static Stage stage0;
	public StartPage sp;
	public GameBoard gb;
	public EndPage ep;
	public static boolean retry;
	
	public SystemManager() throws IOException {
		player1 = new Player();
		player2 = new Player();
		stage0 = new Stage();
		sp = new StartPage(player1,player2);
		gb = new GameBoard(player1, player2);
		ep = new EndPage(player1,player2);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage0.setOnCloseRequest(e->this.stop());
		stage0.setScene(sp.run());
		stage0.showAndWait();
		stage0.setScene(gb.run());
		stage0.showAndWait();
		stage0.setScene(ep.run());
		stage0.showAndWait();
		if(retry) {
			this.retry();
		}
	}
	public void retry() throws IOException {
		player1.reset();
		player2.reset();
		gb = new GameBoard(player1, player2);
		stage0.setScene(gb.run());
		stage0.showAndWait();
		stage0.setScene(ep.run());
		stage0.showAndWait();
		if(retry) {
			this.retry();
		}
	}
	
	public void stop() {
		stage0.close();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
