package logic;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import card.AttackCard;
import card.Card;
import deck.Deck;
import enemy.Enemy;
import enemy.EnemyPool;
import enemy.base.Attackable;
import enemy.base.Sleepable;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import main.Main;
import javafx.scene.control.Alert.AlertType;
import player.Player;
import player.PlayerStatic;

public class Combat {
	public static Combat instance = null;
	public static boolean isCombatEnd;
	public static boolean isCombatWin;
	public static boolean isRoundEnd;
	public static int turn = 0;
	// public static ArrayList<Enemy> listOfEnemy;
	public static ArrayList<Card> inHandCard = new ArrayList<Card>();
	public static ArrayList<Card> startDeck;
	public static ArrayList<Card> discardPile;
	public static Player me;
	public static Enemy rival;
	public static int mana;

	public static void startcombat() {
		Deck k = new Deck();
		k.initDeck();
		startDeck = k.starterDeck;
		setIsCombatEnd(false);
		setIsCombatWin(false);
		turn = 0;
		// rival this.setgetRival();
		EnemyPool pool = new EnemyPool();
		pool.EnemyPoolProgram();
		rival = Combat.getRandomElement(pool.getallTier());
		startTurn(rival);
//		while(Combat.isCombatEnd == false) {
//			turn ++;
//			drawNewTurn();
//			Combat.setIsRoundEnd(false);
//			while(Combat.isRoundEnd == false) {
//				if(Combat.checkEndCombat(rival)) {
//					Combat.setIsCombatEnd(true);
//					Combat.isCombatWin = true;
//					break;
//				}
//			}
//		}
	}

	public static void startTurn(Enemy rival) {
		// TODO Auto-generated method stub
		System.out.println(inHandCard);
		setTurn(getTurn() + 1);
		setMana(4);
		inHandCard = drawNewTurn();

		// also remove cover card
		if (getTurn() != 1) {
			System.out.println(PlayerStatic.hp);
			if (rival instanceof Sleepable) {
				((Sleepable) rival).sleep();
			} else if (rival instanceof Attackable) {
				((Attackable) rival).attack();
			}
			System.out.println(PlayerStatic.hp);
		}
		if (checkEndCombat(rival) == true) {
			startcombat();
		}
		if (checkEndGame() == true) {
			endGame();
		}
//		Main.chapane.setUrl(Combat.rival.getUrl());

	}

	public static void endGame() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText(null);
		String dialogueString = "Game End!\nThe game result is: " + "\nYou Lose!!!" + "\nDo you want to restart?";
		alert.setContentText(dialogueString);
		alert.getButtonTypes().clear();
		ButtonType yes = new ButtonType("Exit");
		alert.getButtonTypes().addAll(yes);
		Optional<ButtonType> re = alert.showAndWait();
		if (re.get() == yes) {
			Platform.exit();
		}

	}

	public static void playCard(Card card, Enemy rival) {
//		System.out.println(rival.getHp());
//		System.out.println(mana);
		if (card instanceof AttackCard & (mana - card.manaaCost >= 0)) {
			rival.setHp(rival.getHp() - ((AttackCard) card).getPower());
			setMana(getMana() - card.manaaCost);
		}

		checkEndCombat(rival);
		// else if (card instanceof )

	}

	public static boolean checkEndGame() {
//		player.setHP(rival.getPower() - player.getHP()); 
		if (PlayerStatic.isAlive == false) {

			return true;
		}
		return false;

	}

	public static boolean checkEndCombat(Enemy rival) {
		if (rival.getHp() <= 0) {
			return true;

			// startcombat();
		}
		return false;
	}

	public static Enemy getRandomElement(ArrayList<Enemy> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

//	public static boolean allEnemyDie() {
//		for(Enemy x : listOfEnemy) {
//			if(x.isAlive == true){
//				return false;
//			}
//		}
//		return true;
//	}
	public static ArrayList<Card> drawNewTurn() {
		ArrayList<Card> inHand = new ArrayList<Card>();
		if (startDeck.size() == 0) {
			isCombatWin = false;
			endGame();
			return null;
		} else if (startDeck.size() >= 5) {
			for (int i = 0; i < 5; i++) {
				Random rand = new Random();
				int randomIndex = rand.nextInt(startDeck.size());
//				inHandCard.add(startDeck.get(randomIndex));
				inHand.add(startDeck.get(randomIndex));
				startDeck.remove(randomIndex);

			}
		}
//		}else if(startDeck.size() < 5 & discardPile.size()!=0){
//			for(Card x : discardPile){
//				startDeck.add(x);
//				discardPile.remove(x);
//			}
//			drawNewTurn();
//		}

		else {
			for (int i = 0; i < startDeck.size(); i++) {
				inHandCard.add(startDeck.get(i));
				inHand.add(startDeck.get(i));
				startDeck.remove(i);
			}
		}
		return inHand;
	}

	public static void draw(int amount) {
		for (int i = 0; i < amount; i++) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(startDeck.size());
			inHandCard.add(startDeck.get(randomIndex));
			startDeck.remove(randomIndex);

		}
	}

	public static void discardEndTurn() {
		for (Card x : inHandCard) {
			discardPile.add(x);
		}
		inHandCard.clear();
	}

	public static void discard(Card card) {
		discardPile.add(card);
		inHandCard.remove(card);
	}

	public static Combat getInstance() {
		if (instance == null) {
			instance = new Combat();
		}
		return instance;
	}

	public boolean isRoundEnd() {
		return isRoundEnd;
	}

	public static void setIsRoundEnd(boolean isRoundEnd) {
		Combat.isRoundEnd = isRoundEnd;
	}

	public boolean isCombatEnd() {
		return isCombatEnd;
	}

	public static void setIsCombatEnd(boolean isCombatEnd) {
		Combat.isCombatEnd = isCombatEnd;
	}

	public boolean isCombatWin() {
		return isCombatWin;
	}

	public static void setIsCombatWin(boolean isCombatWin) {
		Combat.isCombatWin = isCombatWin;
	}

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int turn) {
		Combat.turn = turn;
	}

	public static int getMana() {
		return mana;
	}

	public static void setMana(int mana) {
		Combat.mana = mana;
	}

}
