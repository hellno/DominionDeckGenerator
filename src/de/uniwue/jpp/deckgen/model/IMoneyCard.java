package de.uniwue.jpp.deckgen.model;

/**
 * Specifies behaviour for a money card.
 */
public interface IMoneyCard extends ICard {

  /**
   * Gets the value of this card.
   *
   * @return the value.
   */
  int getValue();
}
