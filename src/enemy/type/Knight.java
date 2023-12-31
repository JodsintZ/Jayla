package enemy.type;

import java.util.Random;

import enemy.Enemy;
import enemy.base.Attackable;
import enemy.base.Healable;
import enemy.base.Ragable;
import enemy.base.Sleepable;
import player.Player;
import player.PlayerStatic;

public class Knight extends Enemy implements Sleepable, Attackable, Healable, Ragable {
	public Knight() {
		super("Knight", 60, 72, 8, 3, "KNIGHT.png");
		this.sleep();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
//		p.setHP(p.getHP()-this.getPower());
//		p.setAlive();
		PlayerStatic.hp = PlayerStatic.hp - this.getPower();
		PlayerStatic.checkIsAlive();
	}

	@Override
	public void rage() {
		// TODO Auto-generated method stub
		this.setPower(this.getPower() + 9);
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		this.setHp(20 + this.getHp());
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int game = r.nextInt(100);

		if (game < 80 / 3) {
			this.attack();
		} else if (game < (160 / 3)) {
			this.heal();
		} else if (game < 240 / 3) {
			this.rage();
		} else {

		}

	}

}
