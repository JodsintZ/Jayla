package main;

import GUI.CardBoard;
import GUI.CardPane;
import GUI.CharacterPane;
import GUI.StatusPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Combat;

public class Main extends Application {
	public static StatusPane statusPane;
	public static CharacterPane chapane;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Button button = new Button("NEW GAME");
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					VBox vbox1 = new VBox();
//					Media media = new Media("THEMESONG.mp3");     
//				    MediaPlayer mediaPlayer = new MediaPlayer(media);     
//				    mediaPlayer.setAutoPlay(true);
					AudioClip buzzer = new AudioClip(
							getClass().getClassLoader().getResource("THEMESONG.mp3").toExternalForm());
					buzzer.play();

					vbox1.setSpacing(10);
					vbox1.setPrefWidth(1200);
					vbox1.setPrefHeight(600);
					vbox1.setPadding(new Insets(10, 10, 10, 10));
					vbox1.setStyle("-fx-background-image: url('BoardBackground.png')");
					Combat.startcombat();
					statusPane = new StatusPane();

					chapane = new CharacterPane();

					CardBoard card = new CardBoard();
					vbox1.getChildren().add(statusPane);
					vbox1.getChildren().add(chapane);
					vbox1.getChildren().add(card);
					Scene sec = new Scene(vbox1);
					primaryStage.setTitle("Jayla");
					primaryStage.setScene(sec);

					primaryStage.show();

				}
			});
			VBox vbox = new VBox();
			vbox.setSpacing(10);
			vbox.setPrefWidth(1200);
			vbox.setPrefHeight(600);
			primaryStage.setResizable(false);
			vbox.setPadding(new Insets(10, 10, 10, 10));
			vbox.setStyle("-fx-background-image: url('BACKGROUNDMAINMENU.png')"); //
			vbox.getChildren().add(button);
			vbox.setAlignment(Pos.CENTER);
			Scene scene = new Scene(vbox);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Jayla");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}