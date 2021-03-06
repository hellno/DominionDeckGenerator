package de.uniwue.jpp.deckgen.service.csp;

import java.util.Set;
import de.uniwue.jpp.deckgen.model.ICard;

/**
 * Interface for implementations that can find a deck that satisfies certain constraints.
 */
public interface ISolver {

    /**
     * Finds a configuration of ten distinct cards that satisfies all the constraints.
     *
     * @param allCards a set of all available cards.
     * @param constraints a set of constraints.
     *
     * @return a set of ten cards satisfying the constraints.
     */
    Set<ICard> solve(Set<ICard> allCards, Set<IConstraint> constraints) throws NoSolutionFoundException;
}