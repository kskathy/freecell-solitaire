package cs3500.freecell.model.hw02;

/**
 * This is the interface for the Freecell cards.
 */
public interface IFreecellCard {

  /**
   * Gets the value of the card.
   *
   * @return the card value
   */
  int getValue();

  /**
   * Gets the suite of the card.
   *
   * @return the card suite
   */
  String getSuite();

  /**
   * Gets a String representation of the card by concatenating the value with the suite symbol
   * unicode.
   *
   * @return The String representation of the card
   */
  String toString();

  /**
   * Gets the color of the card which is Black for Spades and Clubs, and Red for Hearts and
   * Diamonds.
   *
   * @return The color of the card
   */
  String getColor();

  /**
   * Checks the equality of two FreecellCard objects based on the value and suite.
   *
   * @param o The other FreecellCard object
   * @return true if both this card and other card are same, otherwise return false
   */
  boolean equals(Object o);

  /**
   * Computes the hash of this card instance based on suite and value.
   *
   * @return the computed hash value of this card instance.
   */
  int hashCode();

}
