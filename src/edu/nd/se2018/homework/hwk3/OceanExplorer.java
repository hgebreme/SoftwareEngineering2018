package edu.nd.se2018.homework.hwk3;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.*;

// had to add this because of problems
@SuppressWarnings("restriction")
public class OceanExplorer extends Application {
	
	final int scalingFactor = 50;
	final int dimensions = 10;
	final int islandCount = 10;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship columbusShip;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		AnchorPane anchorPane = new AnchorPane();
		oceanMap = new OceanMap();
		oceanMap.drawMap(anchorPane.getChildren(),scalingFactor);
		columbusShip = new Ship();
		
		//Image 
		shipImage = new Image("file:pirateship.png",50,50,false,false);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(columbusShip.getShipLocationX()*scalingFactor);
		shipImageView.setY(columbusShip.getShipLocationY()*scalingFactor);	
		
		anchorPane.getChildren().add(shipImageView);
		Scene scene = new Scene(anchorPane, 500,500);
		
		oceanStage.setScene(scene);
		oceanStage.setTitle("Cristopher Colombus Game");
		oceanStage.show();
		
	}

}
