package card;

import enemy.Enemy;

public abstract class AttackCard extends Card {
	protected int power;
	protected String url;

	public AttackCard(String name, int manaCost, String description, int power, String url) {
		super(name, manaCost, description, url);
		this.setPower(power);
	}

//	private String getUrl() {
//		return url;
//	}
//	private void setUrl(String url) {
//		this.url = url;
//	}
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int attack(Enemy enemy) {
		if (this.power > enemy.getHp()) {
			enemy.setHp(enemy.getHp() - this.power);
			return this.power;
		} else {
			enemy.setHp(0);
			enemy.setAlive();
			return enemy.getHp();
		}
	}
}
