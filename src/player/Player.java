package player;

import card.Card;

import card.Card;

public class Player {
	private String name;
	private int HP;
	private int score;
	private boolean isAlive;

	public Player(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		this.HP = hP;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAlive() {
		if (this.HP > 0) {
			this.isAlive = false;
		} else {
			this.isAlive = true;
		}
	}

}