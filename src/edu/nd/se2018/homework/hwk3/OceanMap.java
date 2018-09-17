package edu.nd.se2018.homework.hwk3;

import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
import javafx.collections.*;

@SuppressWarnings("restriction")
public class OceanMap {
	boolean [][] oceanBool = new boolean [25][25];
	final int dimensions = 25;
	
	public void drawMap (ObservableList<Node> root, int scale){
		for(int x=0; x<dimensions; x++){
			for(int y=0; y<dimensions; y++){
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanBool[x][y] = false;
			}
		}
	}
	
//	public Point getShipLocation(){
//		return currentLocation;
//	}
	
}
