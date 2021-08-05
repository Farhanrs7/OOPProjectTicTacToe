 package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerEndPage implements Controller{
	public Player player1;
	public Player player2;
	@FXML Button exitButton;
	@FXML Button retryButton;
	@FXML Label resultLabel;
	
	public ControllerEndPage(Player p1, Player p2) {
		setPlayers(p1,p2);
	}
	
	public void setResultLabel(Scene scene) {
		resultLabel = (Label) scene.lookup("#resultLabel");
		if(player1.hasWon) {
			resultLabel.setText(player1.name + " has WON!!!");
		}
		else if(player2.hasWon) {
			resultLabel.setText(player2.name + " has WON!!!");
		}
	}
	public void retry() {
		SystemManager.retry=true;
		SystemManager.stage0.close();
	}
	public void exit() {
		SystemManager.retry=false;
		SystemManager.stage0.close();
	}

	@Override
	public void setPlayers(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
	}

}
