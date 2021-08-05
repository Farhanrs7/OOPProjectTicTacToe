package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControllerStartPage implements Controller{
	Player player1;
	Player player2;
	@FXML TextField p1NameField;
	@FXML TextField p2NameField;
	@FXML ToggleGroup p1ShapeCode;
	@FXML ToggleGroup p2ShapeCode;
	
	public ControllerStartPage(Player p1,Player p2) {
		setPlayers(p1,p2);
	}

	@FXML
	public void start(ActionEvent e) throws IOException {
		player1.name = p1NameField.getText();
		player2.name = p2NameField.getText();
		player1.shapeCode = ((RadioButton) p1ShapeCode.getSelectedToggle()).getAccessibleText();
		player2.shapeCode = ((RadioButton) p2ShapeCode.getSelectedToggle()).getAccessibleText();
		SystemManager.stage0.close();
	}


	@Override
	public void setPlayers(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
	}
}
