package de.uniwue.jpp.deckgen.model;

import java.util.HashSet;
import java.util.Set;

public class Deck {

	String title, comment;
	Set<ICard> cards = new HashSet<ICard>();
	
	public Deck(String title, String comment, java.util.Set<ICard> cards) {
		super();
		objectValidator.validate(title);
		objectValidator.validate(comment);
		objectValidator.validate(cards);
		
		this.cards.addAll(cards);
		this.title=title;
		this.comment=comment;
		
		System.out.println("Deck " + title + " erstellt");
	}
	
	/*public boolean contains(Object cardObject){
		for(ICard tempCard : cards){
			if(((AbstractCard)cardObject).equals(tempCard))
				return true;
		}
		return false;
	}*/
	
	
	public String getTitle(){
		return title;
	}
	public String getComment(){
		return comment;
	}
	public Set<ICard> getCards(){
		HashSet<ICard> tempCards = new HashSet<ICard>();
		tempCards.addAll(cards);
		return tempCards;
	}
	
	@Override
	public boolean equals(Object object){
		if(cards == ((Deck) object).getCards())
			return true;
		return cards.containsAll(((Deck) object).getCards());
	}
	
	@Override
	public String toString(){
		
	if(title.length()>12 && comment.length()>12)
		return  "["+title.substring(0,10) + ".. | " + comment.substring(0,10) + "..]";
	else if(comment.length()>12)
		return "["+title + " | " + comment.substring(0,10) + "..]";
	else if(title.length()>12)
		return "["+title.substring(0,10) + ".. | " + comment + "]";
	else
		return  "["+title + " | " + comment + "]";
		
	}

	@Override
	public int hashCode(){
		int sum=0;
		for(ICard tempCard : cards){
			sum+=tempCard.hashCode();
		}
		return sum;
	}
}
