package enemy;

import java.util.Random;

public class Enemy {
	protected int hpStartr;
	protected int hpEndr;
	protected int hpStart;
	public String name;
	public int hp;
	public boolean isAlive;
	public int power;
	public int teir;
	public String url;

	public Enemy(String name, int hpStartr, int hpEndr, int power, int tier, String url) {
		this.setHpStartr(hpStartr);
		this.setHpEndr(hpEndr);
		this.setHpStart(this.hpStartr, this.hpEndr);
		this.setName(name);
		this.setAlive();
		this.setPower(power);
		this.setTeir(tier);
		this.setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	private void setUrl(String url) {
		this.url = url;
	}

	public int getTeir() {
		return teir;
	}

	public void setTeir(int teir) {
		this.teir = teir;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getHpStartr() {
		return hpStartr;
	}

	public void setHpStartr(int hpStartr) {
		this.hpStartr = hpStartr;
	}

	public int getHpEndr() {
		return hpEndr;
	}

	public void setHpEndr(int hpEndr) {
		this.hpEndr = hpEndr;
	}

	public int getHp() {
		return this.hp;
	}

	public int getHpStart() {
		return this.hp;
	}

	public void setHpStart(int hpStart, int hpEnd) {
//		System.out.println(hpStart + "-"+ hpEnd);
		Random n = new Random();
		this.hp = n.nextInt(hpStart, hpEnd);
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAlive() {
		if (this.hp > 0) {
			this.isAlive = false;
		} else {
			this.isAlive = true;
		}
	}

}
