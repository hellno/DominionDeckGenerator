package de.uniwue.jpp.deckgen.model;

public class VictoryCard extends AbstractCard implements IVictoryCard {

	String name, description, extension;
	int cost,victoryPoints;
	
	public VictoryCard(String name, String description, String extension, int cost,int victoryPoints) {
		super(name, description, extension, cost);
		objectValidator.validate(victoryPoints);
		this.victoryPoints = victoryPoints;
	}

	@Override
	public int getVictoryPoints() {
		// TODO Auto-generated method stub
		return victoryPoints;
	}

}
