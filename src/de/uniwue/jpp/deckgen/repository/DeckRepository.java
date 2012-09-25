package de.uniwue.jpp.deckgen.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import de.uniwue.jpp.deckgen.model.Deck;
import de.uniwue.jpp.deckgen.model.objectValidator;

public class DeckRepository implements IDeckRepository {

	HashSet<Deck> decks=new HashSet<Deck>();
	
	public DeckRepository() {
		super();
		decks = new HashSet<Deck>();
	}

	public DeckRepository(Collection<Deck> decks){
		super();
		this.decks = new HashSet<Deck>();
		if(decks!=null)
			this.decks.addAll(decks);
	}
	
	public void add(Deck deck) {
		objectValidator.validate(deck);
		boolean checker = true;
		for(Deck tempDeck : decks){
			if(tempDeck.equals(deck))
				checker=false;
		}
		if(checker){
			decks.add(deck);
			System.out.println("Deck " + deck.getTitle() +" hinzugefügt");
		}
		else
			System.out.println("Deck " + deck.getTitle() + " schon vorhanden, nicht hinzugefügt");
	
	}
	
	
	public void addAll(Set<Deck> decks){
		if(decks!=null){
			for(Deck tempDeck : decks){
				this.add(tempDeck);
			}
		}
	}

	@Override
	public Set<Deck> getAll() {
		Set<Deck> tempDeck = new HashSet<Deck>();
		tempDeck.addAll(decks);
 		return tempDeck;
	}

}
