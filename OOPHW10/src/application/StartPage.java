package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartPage extends Pages{
	public Player player1;
	public Player player2;
	public ControllerStartPage ctrlStartPage;

	
	public StartPage(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
		ctrlStartPage = new ControllerStartPage(p1,p2);
	}
	
	public Scene run() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/StartPage.fxml"));
		fxmlLoader.setController(this.ctrlStartPage);
		Parent root = fxmlLoader.load();
		Scene page = new Scene(root);
		return page;
	}

}
