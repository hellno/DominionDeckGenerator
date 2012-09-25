package de.uniwue.jpp.deckgen.model;

public class ActionAndVictoryCard extends AbstractCard implements IActionCard,
		IVictoryCard {

	String name, description, extension;
	int cost, victoryPoints;;
	
	public ActionAndVictoryCard(String name, String description,
			String extension, int cost, int victoryPoints) {
		super(name, description, extension, cost);
		objectValidator.validate(victoryPoints);
		this.victoryPoints=victoryPoints;
	}

	@Override
	public int getVictoryPoints() {
		return victoryPoints;
	}

}
