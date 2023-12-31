package enemy.type;

import enemy.Enemy;
import enemy.base.Attackable;
import player.Player;
import player.PlayerStatic;

public class Slime extends Enemy implements Attackable {
	public Slime() {
		super("Slime", 15, 22, 5, 1, "SLIME.png");

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
//		p.setHP(p.getHP() - this.getPower());
//		p.setAlive();
		PlayerStatic.hp = PlayerStatic.hp - this.getPower();
		PlayerStatic.checkIsAlive();
	}

}
