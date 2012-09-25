package de.uniwue.jpp.deckgen.model;

public class MoneyAndVictoryCard extends AbstractCard implements IMoneyCard,
		IVictoryCard {
	String name, description, extension;
	int cost, value, victoryPoints;;
	
	
	public MoneyAndVictoryCard(String name, String description,
			String extension, int cost,int value, int victoryPoints) {
		
		super(name, description, extension, cost);
		objectValidator.validate(value);
		objectValidator.validate(victoryPoints);
		this.value=value;
		this.victoryPoints=victoryPoints;
		
	}

	@Override
	public int getVictoryPoints() {
		// TODO Auto-generated method stub
		return victoryPoints;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
