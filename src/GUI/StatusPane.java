package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Combat;
import player.PlayerStatic;

public class StatusPane extends HBox {
	public int playerHp;
	public int enemyHp;

	public int getPlayerHp() {
		return PlayerStatic.hp;
	}

	public int getEnemyHp() {
		return enemyHp;
	}

	public void setPlayerHp(int playerHp) {
		this.playerHp = playerHp;
	}

	public void setEnemyHp(int enemyHp) {
		this.enemyHp = enemyHp;
	}

	public StatusPane() {
		this.prefHeight(USE_COMPUTED_SIZE);
		this.prefWidth(USE_PREF_SIZE);
		this.setPadding(new Insets(10));
		this.setSpacing(100);
		this.setPlayerHp(PlayerStatic.hp);
		this.setEnemyHp(Combat.rival.getHp());
		this.setStyle("-fx-background-color:cornsilk;");
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Text enemyHp = new Text("Tan The Slayer");
		enemyHp.setFont(Font.font("Lucida Sans Unicode", 30));
		this.getChildren().add(enemyHp);
		this.setAlignment(Pos.TOP_CENTER);
	}
}
