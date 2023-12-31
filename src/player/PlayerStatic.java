package player;

import logic.Combat;

public class PlayerStatic {
	private static PlayerStatic instance = null;
	public static String name = "You";
	public static int hp = 69;
	public static int score = 0;
	public static boolean isAlive = true;
	public static int mana = 4;

	public static void newGame() {
		PlayerStatic.hp = 69;
		PlayerStatic.score = 0;
		PlayerStatic.isAlive = true;
	}

	public static boolean checkIsAlive() {
		if (PlayerStatic.hp <= 0) {
			PlayerStatic.isAlive = false;
			return false;
		}
		return true;
	}
}
