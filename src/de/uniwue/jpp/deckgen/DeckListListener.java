package de.uniwue.jpp.deckgen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.uniwue.jpp.deckgen.model.Deck;
import de.uniwue.jpp.deckgen.model.ICard;

public class DeckListListener implements ListSelectionListener {

	private Dominion dominion;
	private JPanel panel;
	private JList<String> cardsList;

	public DeckListListener(Dominion dominion, JPanel panel) {
		super();
		this.dominion=dominion;
		this.panel=panel;
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList<Deck> deckList=((JList<Deck>) e.getSource());
		JPanel cardPanel = new JPanel();
		cardPanel.setName("cardDetailPanel");
		cardPanel.setLayout(new GridLayout(10,1));
		Deck tempDeck = null;
		Iterator<Deck> deckIterator = dominion.getTempDecks().iterator();
		
		int deckCount=0;
		while(deckIterator.hasNext()){
			tempDeck=deckIterator.next();
			if(deckCount==deckList.getSelectedIndex())
				break;
			deckCount++;
		}
		System.out.println("Ausgewähltes Deck: " + tempDeck);
		
		if(panel.getComponentCount()==3){
			System.out.println(panel.getComponent(2).getName() + " entfernt");
			panel.remove(2);
		}
		
		
		JLabel titleLabel = ((JLabel) panel.getComponent(0));
		titleLabel.setText("Title: " + tempDeck.getTitle());
		JLabel commentLabel = ((JLabel) panel.getComponent(1));
		commentLabel.setText("Comment: " + tempDeck.getComment());
		
		Set<ICard> tempCards = tempDeck.getCards();
		String[] cardArray = new String[tempCards.size()];
		Iterator<ICard> cardIterator = tempCards.iterator();
		int cardCount=0;
		
		while(cardIterator.hasNext()){
			ICard tempCard = cardIterator.next();
			JLabel cardLabel = new JLabel();
			cardLabel.setText(tempCard.getName() + " | " + tempCard.getCost());
			cardPanel.add(cardLabel);
		}
		
		panel.add(cardPanel, BorderLayout.LINE_END);
	}

}
