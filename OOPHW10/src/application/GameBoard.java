package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GameBoard extends Pages {
	public Player player1;
	public Player player2;
	public ControllerGameBoard ctrlGameBoard;
	public BoxList boxList;
	public static ArrayList<double[]> winPos;
	
	public GameBoard(Player one,Player two) throws IOException{
		player1 = one;
		player2 = two;
		ctrlGameBoard = new ControllerGameBoard(player1,player2);
	}
	
	public Scene run() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/GameBoard.fxml"));
		fxmlloader.setController(ctrlGameBoard);
		Parent root = fxmlloader.load();
		Scene scene = new Scene(root);
		boxList = new BoxList((AnchorPane) root);
		ctrlGameBoard.setBoxList(boxList);
		Label turnLabel= (Label) scene.lookup("#turnLabel");
		ctrlGameBoard.setTurnLabel(turnLabel);
		return scene;
	}
	
	
	public static boolean checkForWin(Player player) {
		for(double i[]:player.shapePos) {
			double targetX = i[0];
			double targetY = i[1];
			if(isComplete(player.shapePos, 0, targetX)) {
				return true;
			}
			if(isComplete(player.shapePos,1,targetY)) {
				return true;
			}
			if((i[0]+i[1])%2==0) {
				if(isDiagonal(player.shapePos,targetX,targetY)) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isComplete(ArrayList<double[]> arr,int index,double target) {
		int count = 0;
		winPos = new ArrayList<double[]>();
		for (double i[]:arr) {
			if(i[index]==target) {
				count+=1;
				winPos.add(i);
			}
		}	
		if(count==3) {
			return true;
		}
		return false;		
	}
	public static boolean isDiagonal(ArrayList<double[]> arr,double targetX,double targetY) {
		int diagonalRightCount = 0;
		int diagonalLeftCount = 0;
		double target = targetX + targetY;
		for (double i[]:arr) {
			if( (i[0]+i[1])%2==0) {
				if(i[0]==i[1]) {
					diagonalLeftCount+=1;
					
				}
				if(i[0]+i[1]==target){
					diagonalRightCount+=1;
				}
			}
		}	
		if(diagonalRightCount==3 || diagonalLeftCount==3) {
			return true;
		}
		return false;		
	}

}
