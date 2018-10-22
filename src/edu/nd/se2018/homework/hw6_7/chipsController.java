package edu.nd.se2018.homework.hw6_7;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("restriction")
public class chipsController {
	chipsModel chip;
	chipsView chipsView;
	private ObservableList<Node> root;
	private int scale;
	private static chipsController instance = null;
	public static chipsController getInstance(mapdisp map, chipsModel chip) {
		if (instance == null) {
			instance = new chipsController(map, chip);
		}
		return instance;
	}
	protected chipsController(mapdisp map, chipsModel chip) {
		this.chip = chip;
		chipsView = new chipsView(chip);
		chip.attachView(chipsView);
	}
	
	public void loadRootAndScale(ObservableList<Node> root, int scale)
	{
		this.root = root;
		this.scale = scale;
		this.chip.loadRootAndScale(this.root, this.scale);
	}
	
	public void moveEvent(KeyEvent ke) {
		int [] pos = chip.getPosition();
		switch(ke.getCode()){
			case RIGHT:
				chip.setPosition(pos[0]+1, pos[1]);
				chipsView.setChipView("RIGHT", chip);
				break;
			case LEFT:
				chip.setPosition(pos[0]-1, pos[1]);
				chipsView.setChipView("LEFT", chip);
				break;
			case UP:
				chip.setPosition(pos[0], pos[1]-1);
				chipsView.setChipView("UP", chip);
				break;
			case DOWN:
				chip.setPosition(pos[0], pos[1]+1);
				chipsView.setChipView("DOWN", chip);
				break;
			case ESCAPE:
				Platform.exit();
				break;
			default:
				break;
		}
		
	}
	
	public Node getImageView() {
		return chipsView.view;
	}

}