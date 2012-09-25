package de.uniwue.jpp.deckgen.repository;

import de.uniwue.jpp.deckgen.model.Deck;
import java.util.Set;

public interface IDeckRepository {

    /**
     * Adds a deck to the repository. A deck should only be once in the repository.
     *
     * @param deck - deck that should be inserted.
     */
    void add(Deck deck);

    /**
     * Retrieves all decks in the repository.
     *
     * @return a set of all decks.
     */
    Set<Deck> getAll();

}