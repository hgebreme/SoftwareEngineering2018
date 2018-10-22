package edu.nd.se2018.homework.hw6_7;

import java.util.Observable;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
@SuppressWarnings("restriction")
public class chipsModel extends Observable {
	int chips;
	boolean hasBlueKey = false;
	int x;
	int y;
	int[] position = new int[2];
	int[][] gameMap;
	Image tileImage;
	ImageView tileImageView;
	mapdisp mapdisp;
	boolean levelone = true;
	private ObservableList<Node> root;
	private int scale;
	private chipsView chipsView;
	
	public chipsModel(int xPos, int yPos, mapdisp map) {
		x = xPos;
		y = yPos;
		chips = 0;
		mapdisp = map;
		gameMap = mapdisp.getMap();
	}
	
	public void loadRootAndScale(ObservableList<Node> root, int scale)
	{
		this.root = root;
		this.scale = scale;
	}
	
	public int[] getPosition() {
		position[0] = this.x;
		position[1] = this.y;
		return(position);
	}
	
	
	public void setPosition(int xPos, int yPos) {
		if (xPos >= 0 && xPos < 25 && yPos >= 0 && yPos < 25) {
			if (gameMap[xPos][yPos] == 0 ) {
				this.x = xPos;
				this.y = yPos;
			}
			else if (gameMap[xPos][yPos] == 2) {
				this.x = xPos;
				this.y = yPos;
				this.mapdisp.removeChip(xPos, yPos);
				this.addChip();	
			}
			else if (gameMap[xPos][yPos] == 6) {
				this.x = xPos;
				this.y = yPos;
				this.mapdisp.removeKey(xPos, yPos);
				this.hasBlueKey = true;
			}
			else if (gameMap[xPos][yPos] == 4)
			{
				if (this.hasBlueKey)
				{
					this.x = xPos;
					this.y = yPos;
					this.mapdisp.removeKeyWall(xPos, yPos);
				}
			}
			else if (gameMap[xPos][yPos] == 3)
			{
				if (this.chips == 10)
				{
					this.x = xPos;
					this.y = yPos;
					this.mapdisp.removeGate(xPos, yPos);
				}
			}
			else if (gameMap[xPos][yPos] == 5)
			{
				this.x = xPos;
				this.y = yPos;
				if (levelone)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("New Level!");
					alert.setHeaderText("Level One Complete!");
					alert.setContentText("Click OK to go to level two!");
					alert.showAndWait();
					levelone = false;
					mapdisp.setLevelOne(levelone);
					mapdisp.setBlocks();
					mapdisp.setChips();
					mapdisp.drawMap(root, scale);
					mapdisp.drawLevel();
					this.chips = 0;
					this.hasBlueKey = false;	
					this.x = 0;
					this.y = 0;
					this.chipsView.resetChip();
					this.root.add(this.chipsView.getView());
				}
				else
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Game Complete!");
					alert.setHeaderText("You beat the game!");
					alert.setContentText("Click OK to exit!");
					alert.showAndWait();
					Platform.exit();
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public void addChip() {
		this.chips++;
	}
	
	public void attachView(chipsView view) {
		addObserver(view);
		this.chipsView = view;
	}
	
}