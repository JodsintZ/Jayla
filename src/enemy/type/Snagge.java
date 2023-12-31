package enemy.type;

import java.util.Random;

import enemy.Enemy;
import enemy.base.Attackable;
import enemy.base.Sleepable;
import player.Player;
import player.PlayerStatic;

public class Snagge extends Enemy implements Attackable, Sleepable {
	public Snagge() {
		super("Snagge", 75, 80, 18, 3, "SNAGGE.png");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int game = r.nextInt(100);

		if (game < 30) {
			this.setPower(18);
			this.attack();
		} else if (game < 60) {
			this.setPower(16);
			this.attack();
		} else {

		}
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
//		p.setHP(p.getHP()-this.getPower());
//		p.setAlive();
		PlayerStatic.hp = PlayerStatic.hp - this.getPower();
		PlayerStatic.checkIsAlive();
	}

}
