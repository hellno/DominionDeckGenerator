package de.uniwue.jpp.deckgen;

import java.util.Iterator;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.uniwue.jpp.deckgen.model.Deck;
import de.uniwue.jpp.deckgen.model.ICard;

public class DeckListListener implements ListSelectionListener {

	private Dominion dominion;
	private JPanel panel;
	private JList<ICard> cardsList;

	public DeckListListener(Dominion dominion, JPanel panel, JList<ICard> cardsList) {
		super();
		this.dominion=dominion;
		this.panel=panel;
		this.cardsList=cardsList;
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList<Deck> deckList=(JList<Deck>) e.getSource();
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
		
		JLabel titleLabel = ((JLabel) panel.getComponent(0));
		titleLabel.setText(tempDeck.getTitle());
		JLabel commentLabel = ((JLabel) panel.getComponent(1));
		commentLabel.setText(tempDeck.getComment());
		
		Set<ICard> tempCards = tempDeck.getCards();
		ICard[] cardArray = new ICard[tempCards.size()];
		Iterator<ICard> cardIterator = tempCards.iterator();
		int cardCount=0;
		while(cardIterator.hasNext()){
			ICard tempCard = cardIterator.next();
			cardArray[cardCount]=tempCard;
			cardCount++;
		}
		cardsList.setListData(cardArray);
	}

}
