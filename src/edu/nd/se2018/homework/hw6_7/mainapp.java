package edu.nd.se2018.homework.hw6_7;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

@SuppressWarnings("restriction")
public class mainapp extends Application {
	AnchorPane root;
	Scene scene;
	mapdisp chipMap;
	ImageView[][] tiles;
	Image tileImage;
	int scale = 20;
	MediaPlayer mediaPlayer;
	
	chipsModel chip;
	chipsView chipsView;
	chipsController chipsControl;

	@Override
	public void start(Stage gameStage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		chipMap = new mapdisp();
		chipMap.setBlocks();
		chipMap.setChips();
		chipMap.drawMap(root.getChildren(), 20);
		chipMap.drawLevel();
		

		chip = new chipsModel(0, 0, chipMap);
		chip.loadRootAndScale(root.getChildren(), scale);
		chipsView = new chipsView(chip);
		chip.attachView(chipsView);
		chipsControl = chipsController.getInstance(chipMap, chip);
		chipsControl.loadRootAndScale(root.getChildren(), scale);
		root.getChildren().add(chipsControl.getImageView());
		
		gameStage.setScene(scene);
		gameStage.setTitle("Chip's Challenge");
		gameStage.show();		
		startGame(scene);
	}
	
	private void startGame(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				chipsControl.moveEvent(event);
			}
		});
		startMusic();
	}
	
	private void startMusic(){
		String musicFile = "chipMusic.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
