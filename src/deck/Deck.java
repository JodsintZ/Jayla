package deck;

import java.util.ArrayList;

import attackcardtype.*;
import card.Card;

public class Deck {
	public ArrayList<Card> allCard = new ArrayList<Card>();
	public ArrayList<Card> starterDeck = new ArrayList<Card>();

	public void initDeck() {
		Card aerialStrike = new AerialStike();
		Card cleave = new Cleave();
		Card eviscerate = new Eviscerate();
		Card rapidPunch = new RapidPunch();
		Card sigmaPunch = new SigmaPunch();
		Card strike = new Strike();
		Card vampClaw = new VampClaw();

		starterDeck.add(aerialStrike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);
		starterDeck.add(sigmaPunch);
		starterDeck.add(aerialStrike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);
		starterDeck.add(sigmaPunch);

		starterDeck.add(aerialStrike);
		starterDeck.add(cleave);
		starterDeck.add(eviscerate);
		starterDeck.add(rapidPunch);
		starterDeck.add(sigmaPunch);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);
		starterDeck.add(aerialStrike);
		starterDeck.add(cleave);
		starterDeck.add(eviscerate);
		starterDeck.add(rapidPunch);
		starterDeck.add(sigmaPunch);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);
		starterDeck.add(aerialStrike);
		starterDeck.add(cleave);
		starterDeck.add(eviscerate);
		starterDeck.add(rapidPunch);
		starterDeck.add(sigmaPunch);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);
		starterDeck.add(aerialStrike);
		starterDeck.add(cleave);
		starterDeck.add(eviscerate);
		starterDeck.add(rapidPunch);
		starterDeck.add(sigmaPunch);
		starterDeck.add(strike);
		starterDeck.add(vampClaw);

	}

	public ArrayList<Card> getAllCard() {
		return allCard;
	}

	public ArrayList<Card> getStarterDeck() {
		return starterDeck;
	}

}