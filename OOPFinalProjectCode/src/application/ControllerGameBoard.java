package application;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;


public class ControllerGameBoard implements Controller {
	public BoxList boxList;
	public Rectangle tempR;
	public Box currBox;
	public Player player1;
	public Player player2;
	public Player currPlayer;
	public String turn="'s turn";
	public int turnCount=0;
	
	public Label turnLabel;
	
	public ControllerGameBoard(Player one, Player two) {
		setPlayers(one,two);
		this.currPlayer=player1;
	}
	public void setTurnLabel(Label turnNode) {
		this.turnLabel=turnNode;
		this.turnLabel.setText(currPlayer.name+turn);
		turnCount+=1;
	}
	public void setBoxList(BoxList bx) {
		boxList = bx;
	}
	
 	public void drawShapes(KeyEvent event) throws InterruptedException, IOException{
 		if(!currBox.hasShape) {
 			currPlayer.putShape(currBox);
 			double arr[] = {currBox.rect.getX(),currBox.rect.getY()};
 			currPlayer.shapePos.add(arr);
 			if(GameBoard.checkForWin(currPlayer)) {
 				Thread.sleep(1000);
 				currPlayer.hasWon=true;
 				SystemManager.stage0.close();
 			}
 			this.nextPlayer();
 		}
	}
	
	public void highlightBox(MouseEvent e) {
		boxList.unhighlightAll();
		tempR = (Rectangle) e.getSource();
		currBox=boxList.getById(tempR.getId());
		currBox.highlight();
		currPlayer.chosenBox=currBox;
	}
	
	public void nextPlayer() {
		if(currPlayer==player1) {
			currPlayer = player2;
		}
		else {
			currPlayer = player1;
		}
		this.turnLabel.setText(currPlayer.name+turn);
		this.turnCount+=1;
		
	}
	@Override
	public void setPlayers(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
	}

}
