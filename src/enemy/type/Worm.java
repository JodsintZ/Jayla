package enemy.type;

import java.util.Random;

import enemy.Enemy;
import enemy.base.Attackable;
import enemy.base.Sleepable;
import player.Player;
import player.PlayerStatic;

public class Worm extends Enemy implements Sleepable, Attackable {
	public Worm() {
		super("Worm", 40, 44, 11, 2, "WORM.png");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		PlayerStatic.hp = PlayerStatic.hp - this.getPower();
		PlayerStatic.checkIsAlive();
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int game = r.nextInt(100);

		if (game < 40) {
			this.setPower(7);
			this.attack();
		} else if (game < 80) {
			this.setPower(11);
			this.attack();
		} else {
			
		}
	}

}
