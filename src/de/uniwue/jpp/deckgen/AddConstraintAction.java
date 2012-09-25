package de.uniwue.jpp.deckgen;

import java.awt.event.ActionEvent;
import java.util.Set;

import de.uniwue.jpp.deckgen.repository.CardRepository;
import de.uniwue.jpp.deckgen.service.csp.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JList;

public class AddConstraintAction extends AbstractAction{

	private Dominion dominion;
	private CardRepository cardRepo;
	private JList<String> jlist;

	public AddConstraintAction(Dominion dominion, CardRepository cardRepo, JList<String> jlist){
		super();
		this.dominion=dominion;
		this.cardRepo=cardRepo;
		this.jlist = jlist;
	}
	
	public void actionPerformed(ActionEvent e) {
		String stringText = ((JButton)e.getSource()).getText();
		String selection = jlist.getSelectedValue();
		IConstraint tempConstraint=null;
		
		if(selection!=null){
			if(stringText.contains("Card")){
				tempConstraint = new ExcludeCardConstraint(cardRepo.find(selection));
			}
			else{
				tempConstraint = new ExcludeExtensionConstraint(selection);
			}
			dominion.addConstraint(tempConstraint);	
		}
	}

}
