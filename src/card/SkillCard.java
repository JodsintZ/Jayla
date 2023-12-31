package card;

public abstract class SkillCard extends Card {
	public SkillCard(String name, int manaCost, String description, String url) {
		super(name, manaCost, description, url);
	}

	public abstract void skill();

	public abstract void upgrade();

}
