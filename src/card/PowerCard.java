package card;

public abstract class PowerCard extends Card {
	public PowerCard(String name, int manaCost, String description, String url) {
		super(name, manaCost, description, url);
	}

	public abstract void talent();

	public abstract void upgrade();

}
