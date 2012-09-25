package de.uniwue.jpp.deckgen.repository;

import de.uniwue.jpp.deckgen.model.ICard;
import java.util.Set;


public interface ICardRepository {

    /**
     * Adds a card to the repository. A card should only be once in the repository.
     *
     * @param card - card that should be inserted.
     */
    void add(ICard card);

    /**
     * Retrieves all cards in the repository.
     *
     * @return a Set of all cards.
     */
    Set<ICard> getAll();

    /**
     * Finds a card with the given name.
     *
     * @param name the name.
     *
     * @return the card with the name or <code>null</code> if not found.
     */
    ICard find(String name);

}