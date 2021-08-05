package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndPage extends Pages{
	public Player player1;
	public Player player2;
	public ControllerEndPage ctrlEndPage;
	
	public EndPage(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
		ctrlEndPage = new ControllerEndPage(p1,p2);
	}
	
	public Scene run() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/EndPage.fxml"));
		fxmlLoader.setController(ctrlEndPage);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		ctrlEndPage.setResultLabel(scene);
		return scene;
		
	}
	
	

}
