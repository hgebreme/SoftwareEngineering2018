package edu.nd.se2018.homework.hw6_7;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@SuppressWarnings("restriction")
public class chipsView implements Observer {
	public ImageView view;
	private Image chipImageDown;
	private Image chipImageRight;
	private Image chipImageLeft;
	private Image chipImageUp;
	
	
	public chipsView(chipsModel chip) {
		chipImageDown = new Image("images//chip//textures//chipDown.png", 50, 50, true, true);
		chipImageRight = new Image("images//chip//textures//chipRight.png", 50, 50, true, true);
		chipImageLeft = new Image("images//chip//textures//chipLeft.png", 50, 50, true, true);
		chipImageUp = new Image("images//chip//textures//chipUP.png", 50, 50, true, true);
		
		view = new ImageView();
		view.setImage(chipImageDown);
		view.setFitHeight(20);
		view.setFitWidth(20);
		int[] pos = chip.getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
	}
	
	public Node getView() {
		return(view);	
	}
	// Helps set the different images for the different directions
	public void setChipView(String direction, chipsModel chip) {
		switch(direction){
			case "RIGHT":
				view.setImage(chipImageRight);
				break;
			case "LEFT":
				view.setImage(chipImageLeft);
				break;
				
			case "UP":
				view.setImage(chipImageUp);
				
			case "DOWN":
				view.setImage(chipImageDown);
				break;
			default:
				break;
		}
	}
	
	public void resetChip()
	{
		chipImageDown = new Image("images//chip//textures//chipDown.png", 50, 50, true, true);
		view = new ImageView(chipImageDown);
		view.setFitHeight(20);
		view.setFitWidth(20);
		view.setX(0 * 20);
		view.setY(0 * 20);
	}

	@Override
	public void update(Observable o, Object arg) {
		int[] pos = ((chipsModel)o).getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);	
	}

}
