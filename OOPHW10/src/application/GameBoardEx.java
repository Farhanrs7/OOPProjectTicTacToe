package application;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard extends TimerTask {
	public final int DELAY = 100;
	public int size;
	public String backgroundColor;
	public Shapes[] tiles;
	public int[] highlightCoordinate;
	public Draw drawtool;
	public Player[] twoPlayers;
	
	public GameBoard() {
	}
	
	public GameBoard(int size, String color) {
		this.size = size;
		this.backgroundColor = color;
	}
	
	public boolean checkKeyPressed(KeyEvent e){
		if(e.getCode()==KeyCode.X || e.getCode()==KeyCode.O) {
			System.out.println("X or O is pressed");
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean checkMouseClicked(MouseEvent e) {
		if(e.getButton()==MouseButton.PRIMARY) {
			System.out.println("mouse clicked");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void changeHighlightCoor(int[] newCoor) {
		HighlightCoor[0]=newCoor[0];
		HighlightCoor[1]=newCoor[1];
	}
	
	public void refreshBoard() {
		drawtool.repaintAll();
		Timer timer = new Timer();
		timer.schedule(this.refreshBoard(),DELAY);
	}
	
	public Player checkWhosTurn() {
		PLayer notMovedYet= new Player();
		if(twoPlayers[1].numberOfMoves()<twoPlayers[0].numberOfMoves) {
			return twoPlayers[1];
		}
		else {
			return twoPlayers[0];
		}	
	}
	
	public void addPlayer(Player p) {
		if(twoPlayers.size()<2) {
			twoPlayers[twoPlayers.size()-1]= p;
		}
		else {
			System.out.println("There are already two players, please delete current player first if you want to do so.");
		}
	}
	
	public void deletePlayer(Player p) {
		int index=0;
		for(Player a : twoPlayers) {
			if (a==p) {
				twoPlayers[index] = null;
			}
			index+=1;
		}
	}
	
	public void startGame() {
		this.refreshBoard();
	}
	
	public void endGame() {
		timer.cancel();
		System.exit(0);
	}
	
	public void pauseGame() {
		timer.cancel();
		cont = false;
		while(cont=false) {
			cont=this.checkMouseClicked(null);
		}
	}
}

