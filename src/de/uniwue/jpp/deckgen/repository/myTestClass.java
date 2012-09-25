package de.uniwue.jpp.deckgen.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uniwue.jpp.deckgen.io.CardImportService;
import de.uniwue.jpp.deckgen.io.DeckImportExportService;
import de.uniwue.jpp.deckgen.model.*;
import de.uniwue.jpp.deckgen.service.csp.BacktrackingSolver;
import de.uniwue.jpp.deckgen.service.csp.ExcludeCardConstraint;
import de.uniwue.jpp.deckgen.service.csp.IConstraint;

public class myTestClass {

	public myTestClass() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		
		ActionCard eins = new ActionCard("Bibliothek", "macht nix", "Basis", 23);
		ActionCard zwei = new ActionCard("Dorf", "macht nix", "Basis", 23);
		ActionCard drei = new ActionCard("Burggraben", "macht nix", "Basis", 23);
		ActionCard vier = new ActionCard("Jahrmarkt", "macht nix", "Basis", 23);
		ActionCard fünf = new ActionCard("Bürokrat", "macht nix", "Basis", 23);
		ActionCard sechs = new ActionCard("Kapelle", "macht nix", "Basis", 23);
		ActionCard sieben = new ActionCard("Werkstatt", "macht nix", "Basis", 23);
		ActionCard acht = new ActionCard("Markt", "macht nix", "Basis", 23);
		ActionCard neun = new ActionCard("Miliz", "macht nix", "Basis", 23);
		ActionCard zehn = new ActionCard("Hexe", "macht nix", "Basis", 23);
		ActionCard elf = new ActionCard("Arsch", "macht nix", "Basis", 23);
		ActionCard zwölf = new ActionCard("Tony", "macht nix", "Basis", 23);
		ActionCard dreizehn = new ActionCard("Döner", "macht nix", "Basis", 23);
		VictoryCard victory = new VictoryCard("SIEG" , "einfach gewinnen", "Basis", 23,3);
		
		Set<ICard> tempDeckCards = new HashSet<ICard>();
		tempDeckCards.add(eins);
		tempDeckCards.add(zwei);
		tempDeckCards.add(drei);
		tempDeckCards.add(vier);
		tempDeckCards.add(fünf);
		tempDeckCards.add(sechs);
		tempDeckCards.add(sieben);
		tempDeckCards.add(acht);
		tempDeckCards.add(neun);
		tempDeckCards.add(zehn);
		
		Set<ICard> copyDeckCards = new HashSet<ICard>();
		copyDeckCards.add(eins);
		copyDeckCards.add(zwei);
		copyDeckCards.add(drei);
		copyDeckCards.add(vier);
		copyDeckCards.add(fünf);
		copyDeckCards.add(sechs);
		copyDeckCards.add(sieben);
		copyDeckCards.add(acht);
		copyDeckCards.add(neun);
		copyDeckCards.add(zehn);
		
		
		Deck tempDeck = new Deck("ErstesDeck", "macht nix", tempDeckCards);
		Deck copyDeck = new Deck("Check","TEST",copyDeckCards);
		Set<ICard> checkDeckCards = new HashSet<ICard>();
		checkDeckCards.addAll(tempDeckCards);
		Deck checkDeck = new Deck("CheckDeck" , "Deck zum Testen" , checkDeckCards);
		
		DeckRepository myDeckRepo = new DeckRepository();
		CardRepository myCardRepo = new CardRepository(tempDeckCards);
		
		System.out.println("myCardRepo(Dorf): " + myCardRepo.find("Dorf"));
		
		Set<ICard> allCards = new HashSet<ICard>();
		allCards.addAll(tempDeckCards);
		allCards.add(elf);
		allCards.add(zwölf);
		allCards.add(dreizehn);
		
		myDeckRepo.add(tempDeck);
		
		DeckImportExportService deckIO = new DeckImportExportService(myCardRepo);
		CardImportService cardInput = new CardImportService();
		
		File file = new File("/Users/holger/AeroFS/dev/Java/DominionDeckGenerator/decksTest.xml");
		InputStream in;
		Set<Deck> importedDecks = null;
		try {
			in = new FileInputStream(file);
			importedDecks = deckIO.importFrom(in);
			myDeckRepo.addAll(importedDecks);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<ICard> importedCards=null;
		file = new File("/Users/holger/AeroFS/dev/Java/DominionDeckGenerator/cardsTest.xml");
		try {
			in = new FileInputStream(file);
			importedCards = cardInput.importFrom(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashSet<Deck> deckSet = new HashSet<Deck>();
		deckSet.add(tempDeck);
		deckIO.exportTo(deckSet, System.out);
		
		ExcludeCardConstraint keineHexe = new ExcludeCardConstraint(zehn);
		HashSet<IConstraint> constraints = new HashSet<IConstraint>();
		constraints.add(keineHexe);
		//BacktrackingSolver mySolver = new BacktrackingSolver();
		//Set<ICard> solvedDeck = mySolver.solve(allCards, constraints);
		//Deck solveDeck = new Deck("solverBenutzt", "hallo", solvedDeck);
		
		System.out.println("DeckVergleich1: " + tempDeck.equals(copyDeck));
		System.out.println("DeckVergleich2: " + copyDeck.equals(copyDeck));
		System.out.println("Hash tempDeck: " + tempDeck.hashCode());
		System.out.println("Hash copyDeck: " + copyDeck.hashCode());
		
		ActionCard compCard1 = new ActionCard("Tony", "macht nix", "Basis", 23);
		VictoryCard compCard2 = new VictoryCard("Tony", "TEST", "Arsch", 42,12);
		System.out.println(compCard1 + " | " + compCard2 + " "+compCard1.equals(compCard2));
		
		
	}

}
