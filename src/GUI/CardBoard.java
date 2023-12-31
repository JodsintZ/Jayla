package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.Combat;
import main.Main;
import player.PlayerStatic;
import card.Card;
import enemy.type.Birdy;

import java.util.ArrayList;
import java.util.Optional;

import attackcardtype.Strike;

public class CardBoard extends TilePane {
//	private ArrayList<CardPane> allcard;
	public Button endTurnButton;
	public Text gameText;
	public ArrayList<Card> newCardSet;

	public CardBoard() {
//		this.setAllcard(cardInHand);
		this.setHgap(USE_COMPUTED_SIZE);
		this.setVgap(USE_COMPUTED_SIZE);
		this.setPrefWidth(1200);
		this.setTileAlignment(Pos.CENTER);
		this.setPrefHeight(USE_PREF_SIZE);
		// this.setStyle("-fx-background-image: url('BoardBackground.png')");
		this.setPadding(new Insets(8, 8, 8, 8));
		this.setAlignment(Pos.CENTER);
		int count = 0;
		ArrayList<Card> cardInHand = Combat.inHandCard;
		for (int j = 0; j < 7; j++) {
//				if( j==0) {
//					Text t = initializeGameText();
//			        GridPane.setRowIndex(t, 0);
//			        GridPane.setColumnIndex(t, j);
//					this.getChildren().add(t);
			if (j == 5) {
//					Pane k = initializeEndTurnButton();
				Button k = new Button("End Turn");
				k.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Combat.startTurn(Combat.rival);
						updateBoard(Combat.inHandCard);
						Main.statusPane.setPlayerHp(PlayerStatic.hp);
						Main.statusPane.setEnemyHp(Combat.rival.hp);
					}
				});
				k.setAlignment(Pos.CENTER);
				GridPane.setRowIndex(k, 0);
				GridPane.setColumnIndex(k, j);
				this.getChildren().add(k);
			} else if (j == 6) {
				Text a = new Text("Your hp left :" + PlayerStatic.hp + "\nEnemy hp left :");
				GridPane.setRowIndex(a, 0);
				GridPane.setColumnIndex(a, j);
				a.setFont(Font.font("Lucida Sans Unicode", 10));
				a.setFill(Color.WHITE);
				this.getChildren().add(a);
			} else {
				CardPane mp = new CardPane(cardInHand.get(count).getName(), cardInHand.get(count).getUrl(),
						cardInHand.get(count));
				count++;
				GridPane.setRowIndex(mp, 0);
				GridPane.setColumnIndex(mp, j);
				this.getChildren().add(mp);

			}
		}
	}

	public void updateBoard(ArrayList<Card> newInHand) {
//		System.out.println(this.getChildren());
		this.getChildren().removeAll(this.getChildren());
		int count = 0;
		ArrayList<Card> cardInHand = Combat.inHandCard;
		for (int i = 0; i < cardInHand.size() + 2; i++) {
			if (i == cardInHand.size()) {
				Button k = new Button("End Turn");
				k.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Combat.startTurn(Combat.rival);
						updateBoard(Combat.inHandCard);

					}
				});
				k.setAlignment(Pos.CENTER);
				GridPane.setRowIndex(k, 0);
				GridPane.setColumnIndex(k, i);
				this.getChildren().add(k);
			} else if (i == cardInHand.size() + 1) {
				Text a = new Text("Your hp left :" + PlayerStatic.hp + "\nEnemy hp left :" + Combat.rival.hp);
				GridPane.setRowIndex(a, 0);
				GridPane.setColumnIndex(a, i);
				a.setFont(Font.font("Lucida Sans Unicode", 10));
				a.setFill(Color.WHITE);
				this.getChildren().add(a);
			} else {
				CardPane mp = new CardPane(cardInHand.get(count).getName(), cardInHand.get(count).getUrl(),
						cardInHand.get(count));

//			CardPane mp = new CardPane("bra", "STRIKE.png", new Strike());
				// this.allcard.add(mp);
				count++;
				GridPane.setRowIndex(mp, 0);
				GridPane.setColumnIndex(mp, i);
				this.getChildren().add(mp);
			}
		}
	}

	private ArrayList<Card> getNewCardSet() {
		return newCardSet;
	}

	private void setNewCardSet(ArrayList<Card> newCardSet) {
		this.newCardSet = newCardSet;
	}

	public Pane initializeEndTurnButton() {
		Pane bt = new Pane();
		this.endTurnButton = new Button("End Turn");
		this.endTurnButton.setAlignment(Pos.CENTER);
		this.endTurnButton.setPrefWidth(100);
		this.endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				;// GameLogic

			}
		});
		bt.getChildren().add(this.endTurnButton);
		return bt;
	}
//	public Text initializeGameText() { 
//		this.gameText = new Text("Cards left");
//		this.gameText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 35));
//		return this.gameText;
//	}	

//	private ArrayList<CardPane> getAllcard() {
//		return allcard;
//	}
//	private void setAllcard(ArrayList<CardPane> allcard) {
//		this.allcard = allcard;
//	}
}
