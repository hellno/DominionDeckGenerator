package de.uniwue.jpp.deckgen.model;

import de.uniwue.jpp.deckgen.repository.ICardRepository;

public class objectValidator {

	public static void validate(int number){
		if(number<0){
			throw new NegativeNumberException();
		}
	}
	public static void validate(String myString){
		if(myString==null){
			throw new NullPointerException();
		}
		if(myString.toString().isEmpty()){
			throw new EmptyStringException();
		}
	}
	public static void validate(java.util.Set<ICard> set){
		if(set==null)
			throw new NullPointerException();
		if(set.size()!=10)
			throw new WrongDeckSizeException();
	}
	
	public static void validate(ICard card){
		if(card==null)
			throw new NullPointerException();
	}
	
	public static void validate(Deck deck){
		if(deck==null)
			throw new NullPointerException();
	}
	public static void validate(ICardRepository repository){
		if(repository==null)
			throw new NullPointerException();
	}
	public static void validate(de.uniwue.jpp.deckgen.service.csp.IConstraint constraint) {
		if(constraint==null)
			throw new NullPointerException();
	}
	
}
