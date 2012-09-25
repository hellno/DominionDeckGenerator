package de.uniwue.jpp.deckgen;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ChangeFrontPanelAction extends AbstractAction {


	private static final long serialVersionUID = 1L;
	private Dominion dominion;
	private String targetFrame;
	
	public ChangeFrontPanelAction(Dominion dominion, String targetFrame) {
		super(targetFrame);
		this.dominion=dominion;
		this.targetFrame=targetFrame;
		
	}

	public void actionPerformed(ActionEvent evt) {
		dominion.changeFrontPanel(targetFrame);
		System.out.println("FrontPanel zu " + targetFrame + " gewechselt");
        
    }
	
}
