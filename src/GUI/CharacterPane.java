package GUI;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.Combat;

public class CharacterPane extends HBox {
	public String url;

	public CharacterPane() {
		this.prefHeight(600);
		this.prefWidth(1200);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(400);
		
		Image img = new Image(getClass().getClassLoader().getResource("pngfind.com-kid-flash-png-1346447.png").toString());
        ImageView img2 = new ImageView(img);
		
		//Image img = new Image("pngfind.com-kid-flash-png-1346447.png");
		this.setUrl(Combat.rival.url);
		
		Image img3 = new Image(getClass().getClassLoader().getResource(this.getUrl()).toString());
        ImageView eimg2 = new ImageView(img3);
		
		//Image eimg = new Image(this.getUrl());
		//ImageView eimg2 = new ImageView();
		//ImageView img2 = new ImageView();
		//eimg2.setImage(eimg);
		eimg2.setFitHeight(250);
		eimg2.setPreserveRatio(true);
		
		//img2.setImage(img);
		img2.setFitHeight(100);
		img2.setPreserveRatio(true);
		this.getChildren().add(img2);
		this.getChildren().add(eimg2);
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
