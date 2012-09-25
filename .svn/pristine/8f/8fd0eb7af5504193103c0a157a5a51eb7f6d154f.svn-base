package de.uniwue.jpp.deckgen.service.csp;

import java.util.Set;

import de.uniwue.jpp.deckgen.model.ICard;
import de.uniwue.jpp.deckgen.model.objectValidator;

public class ExcludeExtensionConstraint implements IConstraint {

	private String extension=null;
	
	public ExcludeExtensionConstraint(String extension) {
		super();
		objectValidator.validate(extension);
		this.extension = extension;
	}

	public boolean isSatisfied(Set<ICard> cards) {
		for(ICard tempCard : cards){
			if(tempCard.getExtension().equals(extension))
				return false;
		}
		return true;
	}

	@Override
	public boolean isSatisfied(ICard card) {
		return extension.equals(card.getExtension());
	}
	
	public String toString(){
		return "ExcludeExtension: " + extension;
	}
	
	public boolean equals(IConstraint constraint) {
		return constraint.toString().equals(this.toString());
	}


}
