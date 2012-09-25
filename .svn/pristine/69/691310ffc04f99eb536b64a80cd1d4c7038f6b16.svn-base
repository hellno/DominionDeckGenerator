package de.uniwue.jpp.deckgen.model;

public abstract class AbstractCard implements ICard {

	private String name, description, extension;
	private int cost;
	
	protected AbstractCard(String name, String description, String extension, int cost){
		super();
		objectValidator.validate(name);
		objectValidator.validate(description);
		objectValidator.validate(extension);
		objectValidator.validate(cost);
		
		this.name=name;
		this.description=description;
		this.extension=extension;
		this.cost=cost;
		
		
	}
	
	
	public boolean equals(Object cardObject){
		if(name.equals(((AbstractCard) cardObject).getName()))
			return true;
		else
			return false;
	}
	
	public int hashCode(){
		return name.hashCode();
	}
	
	
	public String getName() {		 
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getExtension() {
		return extension;
	}

	public int getCost() {
		return cost;
	}
	
	public String toString(){
		return name + " - " + description + " - " + extension + " - " + "cost: " +  cost;
	}

}
