package attackcardtype;

import card.AttackCard;
import player.PlayerStatic;

public class SigmaPunch extends AttackCard {
	public SigmaPunch() {
		super("Sigma Punch",0,"Spend all your mana Deal that much * 9 damage.",PlayerStatic.mana*9,"SIGMAPUNCH.png");
	}


}
