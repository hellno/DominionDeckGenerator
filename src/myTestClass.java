

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uniwue.jpp.deckgen.io.CardImportService;
import de.uniwue.jpp.deckgen.io.DeckImportExportService;
import de.uniwue.jpp.deckgen.model.*;
import de.uniwue.jpp.deckgen.repository.CardRepository;
import de.uniwue.jpp.deckgen.repository.DeckRepository;
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
		copyDeckCards.add(zwölf);
		copyDeckCards.add(zwei);
		copyDeckCards.add(drei);
		copyDeckCards.add(vier);
		copyDeckCards.add(elf);
		copyDeckCards.add(sechs);
		copyDeckCards.add(sieben);
		copyDeckCards.add(acht);
		copyDeckCards.add(neun);
		copyDeckCards.add(eins);
		
		Set<ICard> wrongDeckCards = new HashSet<ICard>();
		wrongDeckCards.add(eins);
		wrongDeckCards.add(zwei);
		wrongDeckCards.add(drei);
		wrongDeckCards.add(vier);
		wrongDeckCards.add(elf);
		wrongDeckCards.add(sechs);
		wrongDeckCards.add(sieben);
		wrongDeckCards.add(acht);
		wrongDeckCards.add(neun);
		wrongDeckCards.add(zwölf);
		
		
		Deck tempDeck = new Deck("ErstesDeck", "macht nix", tempDeckCards);
		Deck copyDeck = new Deck("Check","TEST",copyDeckCards);
		Deck wrongDeck = new Deck("Check" , "TEST", wrongDeckCards);
		
		DeckRepository myDeckRepo = new DeckRepository();
		CardRepository myCardRepo = new CardRepository(tempDeckCards);
		
		Set<ICard> allCards = new HashSet<ICard>();
		allCards.addAll(tempDeckCards);
		allCards.add(elf);
		allCards.add(zwölf);
		allCards.add(dreizehn);
		
		myDeckRepo.add(tempDeck);
		myCardRepo.addAll(tempDeckCards);
		
		DeckImportExportService deckIO = new DeckImportExportService(myCardRepo);
		CardImportService cardInput = new CardImportService();
		
		File file = new File("/Users/holger/AeroFS/dev/Java/DominionDeckGenerator/decksTest.xml");
		InputStream in;
		Set<Deck> importedDecks = new HashSet<Deck>();
		try {
			in = new FileInputStream(file);
			importedDecks = deckIO.importFrom(in);
			myDeckRepo.addAll(importedDecks);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<ICard> importedCards= new HashSet<ICard>();
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
		
		
		System.out.println("DeckVergleich1:" + tempDeck.equals(copyDeck));
		System.out.println("DeckVergleich2(self):" + copyDeck.equals(copyDeck));
		System.out.println("DeckVergleich3:" + copyDeck.equals(wrongDeck));
		
	}

}
