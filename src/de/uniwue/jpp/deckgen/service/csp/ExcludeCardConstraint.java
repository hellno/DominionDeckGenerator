package de.uniwue.jpp.deckgen.service.csp;

import java.util.Set;

import de.uniwue.jpp.deckgen.model.ICard;
import de.uniwue.jpp.deckgen.model.objectValidator;
import de.uniwue.jpp.deckgen.service.csp.IConstraint;

public class ExcludeCardConstraint implements IConstraint {
	
	ICard excludeThisCard = null;
	
	public ExcludeCardConstraint(ICard card){
		super();
		objectValidator.validate(card);
		excludeThisCard = card;
	}
	
	public boolean isSatisfied(Set<ICard> cards) {
		for(ICard tempCard : cards){
			if(tempCard.equals(excludeThisCard))
					return false;
		}
		return true;
	}

	public boolean isSatisfied(ICard card) {
		return excludeThisCard.equals(card);
	}
	
	public String toString(){
		return "ExcludeCard: " + excludeThisCard;
	}

	public boolean equals(IConstraint constraint) {
		return constraint.toString().equals(this.toString());
	}

}
