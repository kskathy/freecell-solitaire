package cs3500.freecell.model.hw02;

import java.util.Objects;

/**
 * This class models a card in the Freecell game that has a suite and a rank/value from 1 to 13 as
 * below Ace is equivalent to 1, 2 is equivalent to 2, 3 is equivalent to 3, and so on. Jack is
 * equivalent to 11, Queen is equivalent to 12, and King is equivalent to 13.
 */
public class FreecellCardImpl implements IFreecellCard {

  public static final String SYMBOL_HEARTS = "♥";
  public static final String SYMBOL_DIAMONDS = "♦";
  public static final String SYMBOL_CLUBS = "♣";
  public static final String SYMBOL_SPADES = "♠";


  /**
   * Represents the suite of a card which can be among Clubs, Diamonds, Hearts and Spades.
   */
  private String suite;

  /**
   * Represents th rank/value of the card a number between 1 and 13.
   */
  private int value;

  /**
   * Class constructor that creates a new FreecellCard with given parameters.
   *
   * @param suite The suite of the card
   * @param value The value of the card
   * @throws IllegalArgumentException if the suite is null or a value is 0.
   */
  public FreecellCardImpl(String suite, int value) {
    if (suite == null || value == 0) {
      throw new IllegalArgumentException("Invalid card.");
    }
    this.suite = suite;
    this.value = value;
  }

  /**
   * Gets the value of the card.
   *
   * @return the card value
   */
  public int getValue() {
    return value;
  }

  /**
   * Gets the suite of the card.
   *
   * @return the card suite
   */
  public String getSuite() {
    return suite;
  }

  /**
   * Gets the value of the card as a String computed as below 1 -> "A" 2..10 -> the value as string
   * 11 -> "J" 12 -> "Q" 13 -> "K".
   *
   * @return the string representation of the value
   */
  private String getValueString() {
    if (value == 1) {
      return "A";
    } else if (value == 11) {
      return "J";
    } else if (value == 12) {
      return "Q";
    } else if (value == 13) {
      return "K";
    } else {
      return value + "";
    }
  }

  /**
   * Gets the unicode symbol for the suite of the card.
   *
   * @return The unicode symbol for the suite
   */
  private String getSuiteSymbol() {
    switch (suite) {
      case "Diamonds":
        return SYMBOL_DIAMONDS;
      case "Spades":
        return SYMBOL_SPADES;
      case "Clubs":
        return SYMBOL_CLUBS;
      default:
        return SYMBOL_HEARTS;
    }
  }

  /**
   * Gets a String representation of the card by concatenating the value with the suite symbol
   * unicode.
   *
   * @return The String representation of the card
   */
  @Override
  public String toString() {
    String valStr = getValueString();
    String suiteSymbol = getSuiteSymbol();
    return valStr + suiteSymbol;
  }

  /**
   * Gets the color of the card which is Black for Spades and Clubs, and Red for Hearts and
   * Diamonds.
   *
   * @return The color of the card
   */
  public String getColor() {
    if (suite.equals("Spades") || suite.equals("Clubs")) {
      return "Black";
    } else {
      return "Red";
    }
  }

  /**
   * Checks the equality of two FreecellCard objects based on the value and suite.
   *
   * @param o The other FreecellCard object
   * @return true if both this card and other card are same, otherwise return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FreecellCardImpl that = (FreecellCardImpl) o;
    return value == that.value && suite.equals(that.suite);
  }

  /**
   * Computes the hash of this card instance based on suite and value.
   *
   * @return the computed hash value of this card instance.
   */
  @Override
  public int hashCode() {
    return Objects.hash(suite, value);
  }
}
