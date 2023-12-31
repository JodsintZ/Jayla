package enemy.type;

import java.util.Random;

import enemy.Enemy;
import enemy.base.Attackable;
import enemy.base.Ragable;
import enemy.base.Sleepable;
import player.Player;
import player.PlayerStatic;

public class Birdy extends Enemy implements Attackable, Ragable, Sleepable {
	public Birdy() {
		super("Birdy", 22, 28, 1, 1, "BIRDY.png");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int game = r.nextInt(100);

		if (game < 30) {
			this.attack();
		} else if (game < 60) {
			this.rage();
		} else {

		}
	}

	@Override
	public void rage() {
		// TODO Auto-generated method stub
		this.setPower(this.getPower() + 3);

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
//		p.setHP(p.getHP()-(4*this.getPower()));
//		p.setAlive();
		PlayerStatic.hp = PlayerStatic.hp - (4 * this.getPower());
		PlayerStatic.checkIsAlive();
	}

}
