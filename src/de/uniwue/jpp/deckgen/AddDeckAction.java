package de.uniwue.jpp.deckgen;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.uniwue.jpp.deckgen.model.Deck;
import de.uniwue.jpp.deckgen.service.csp.IConstraint;

public class AddDeckAction extends AbstractAction  {

	
	private Dominion dominion;
	private JPanel jpanel;

	public AddDeckAction( Dominion dominion, JPanel jpanel) {
		super();
		this.dominion=dominion;
		this.jpanel=jpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		String title = ((JTextField)jpanel.getComponent(0)).getText();
		String comment = ((JTextField)jpanel.getComponent(1)).getText();
		Deck tempDeck = new Deck(title, comment, dominion.getSolvedCards());
		dominion.addDeckToRepo(tempDeck);
		
	}

	

}
