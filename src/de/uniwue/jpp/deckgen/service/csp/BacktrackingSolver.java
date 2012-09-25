package de.uniwue.jpp.deckgen.service.csp;

import java.util.HashSet;
import java.util.Set;

import de.uniwue.jpp.deckgen.model.ICard;

public class BacktrackingSolver implements ISolver {

	public BacktrackingSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<ICard> solve(Set<ICard> allCards, Set<IConstraint> constraints)
			throws NoSolutionFoundException {
		Set<ICard> goodCards = new HashSet<ICard>();
		for(ICard tempCard : allCards){
			if(checkConstraints(tempCard,constraints))
				goodCards.add(tempCard);
			if(goodCards.size()==10){
				System.out.println("Lösung gefunden!");
				return goodCards;
			}
		}
		throw new NoSolutionFoundException("",constraints);
	}

	private boolean checkConstraints(ICard card, Set<IConstraint> constraints){
		for(IConstraint constraint: constraints){
			if(!constraint.isSatisfied(card))
				return false;
		}
		return true;
	}
	
}
