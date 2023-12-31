package GUI;

import card.AttackCard;
import card.Card;
import enemy.Enemy;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.Combat;

public class CardPane extends Pane{	
	public boolean isDrawn;
	public String cardName;
	public String url;
	public Card card;
	public boolean isUsed; 
	public Enemy enemy;
	
	public CardPane(String name,String url,Card card) {
		this.setUrl(url);
		this.setCardName(name);
		this.setDrawn(false);
		this.setCard(card);
		this.isUsed = false;
		Image img = new Image(getClass().getClassLoader().getResource(this.getUrl()).toString());
        ImageView img2 = new ImageView(img);
		//Image img = new Image(this.getUrl());
		//ImageView img2 = new ImageView();
		//img2.setImage(img);
		img2.setFitWidth(150);
		img2.setPreserveRatio(true);
		this.getChildren().add(img2);
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onClickHandler();
				updateFlip();
			}
		};
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
	}
	private Card getCard() {
		return card;
	}
	private void setCard(Card card) {
		this.card = card;
	}
	public void updateFlip() {
		Image img = new Image(getClass().getClassLoader().getResource("CARDCOVER2.png").toString());
		//Image img = new Image("CARDCOVER2.png");
		//ImageView img2 = new ImageView();
		ImageView img2 = new ImageView(img);
		img2.setPreserveRatio(true);
		img2.setFitWidth(140);
		this.getChildren().add(img2);
	}

	
	public void onClickHandler() {
		if(this.getCard() instanceof AttackCard) {
			Combat.playCard(this.getCard(), Combat.rival);
//			System.out.println("pong");;
			this.setDisable(true);;
		}
//		Thread t = new Thread(()->{
//			try {
//				Platform.runLater(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						updateFlip();
//					}
//				});
//				Thread.sleep(10);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		});
//		t.start();
	}

	private String getUrl() {
		return url;
	}

	private void setUrl(String url) {
		this.url = url;
	}

	private boolean isDrawn() {
		return isDrawn;
	}

	private String getCardName() {
		return cardName;
	}

	private void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}

	private void setCardName(String cardName) {
		this.cardName = cardName;
	}
}
