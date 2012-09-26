package de.uniwue.jpp.deckgen;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class SaveGeneratedDecks extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;
	private Dominion dominion=null;

	public SaveGeneratedDecks(String name, Dominion dominion) {
		super(name);
		this.dominion=dominion;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		dominion.saveDecksToRepo();
		dominion.exportDeckToFile();
		//System.out.println("Decks in Repo gespeichert");
	}

}
