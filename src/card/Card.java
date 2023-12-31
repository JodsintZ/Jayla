package card;

public abstract class Card {
	public String name;
	public int manaaCost;
	public boolean isUpgraded;
	public String description;
	public String url;

	public Card(String name, int manaCost, String description, String url) {
		this.setManaaCost(manaCost);
		this.setName(name);
		this.setisUpgraded(false);
		this.setDescription(description);
		this.setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManaaCost() {
		return manaaCost;
	}

	public void setManaaCost(int manaaCost) {
		this.manaaCost = manaaCost;
	}

	public boolean isUpgraded() {
		return isUpgraded;
	}

	public void setisUpgraded(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public void setDescription(String script) {
		this.description = script;
	}

	public String getDescription() {
		return this.description;
	}
}
