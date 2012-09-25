package de.uniwue.jpp.deckgen.model;

public class MoneyCard extends AbstractCard implements IMoneyCard {

	String name, description, extension;
	int cost,value;
	
	
	public MoneyCard(String name, String description, String extension, int cost, int value) {
		super(name, description, extension, cost);
		objectValidator.validate(value);
		this.value=value;
		
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
