package de.uniwue.jpp.deckgen.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import de.uniwue.jpp.deckgen.model.ICard;
import de.uniwue.jpp.deckgen.model.objectValidator;

public class CardRepository implements ICardRepository {

	Set<ICard> cards = new HashSet<ICard>();
	Set<String> extensions = new HashSet<String>();
	
	public CardRepository() {
		super();
		cards = new HashSet<ICard>();
	}

	public CardRepository(Collection<ICard> cards){
		super();
		this.cards = new HashSet<ICard>();
		if(cards!=null){
			for(ICard tempCard : cards){
				this.add(tempCard);
			}
				
		}
	}
	
	public Set<String> getExtensions(){
		HashSet<String> tempExt = new HashSet<String>();
		tempExt.addAll(extensions);
		return tempExt;
	}
	
	public void add(ICard card) {
		objectValidator.validate(card);
		if(!cards.contains(card))
			cards.add(card);
		if(!extensions.contains(card.getExtension()))
			extensions.add(card.getExtension());
		
		//System.out.println(card.getName() + " hinzugefügt");
	}
	
	public void addAll(Set<ICard> cards){
		if(cards!=null)
		for(ICard card : cards){
			this.add(card);
		}
	}

	public Set<ICard> getAll() {
		Set<ICard> tempCards  = new HashSet<ICard>();
		tempCards.addAll(cards);
		return tempCards;
	}

	public ICard find(String name) {
		objectValidator.validate(name);
		for(ICard tempCard : cards){
			if(tempCard.getName().equals(name))
				return tempCard;
		}
		return null;
	}
	

}
