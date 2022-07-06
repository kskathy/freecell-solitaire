package cs3500.freecell.model.hw02;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// All protected fields and methods were changed from private to protected in order for the
// subclass to be able to access.

/**
 * This class implements the interface FreeCellModel using an instance of FreecellCard as the
 * generic type for K.
 */
public class SimpleFreecellModel implements FreecellModel<IFreecellCard> {

  /**
   * An array containing constants for all the suite names.
   */
  protected static final String[] SUITES = {"Hearts", "Diamonds", "Clubs", "Spades"};

  /**
   * A list for storing all cascade piles of cards.
   */
  protected final List<List<IFreecellCard>> cascadePiles;

  /**
   * A list for storing all foundation piles of cards.
   */
  protected final List<List<IFreecellCard>> foundationPiles;

  /**
   * A list for storing all open piles of cards.
   */
  protected final List<List<IFreecellCard>> openPiles;

  /**
   * Indicates whether the game has started or not.
   */
  protected boolean gameStarted;

  /**
   * Indicates whether the game has ended or not.
   */
  protected boolean gameEnded;

  /**
   * Represents a card that is moving.
   */
  protected IFreecellCard cardToMove;

  /**
   * A list of cards in the source pile.
   */
  protected List<IFreecellCard> sourcePile;

  /**
   * A list of cards in the destination pile.
   */
  protected List<IFreecellCard> destPile;

  /**
   * Class constructor for creating new SimpleFreecellModel instance that creates empty piles and
   * sets the game ended and started flag to false.
   */
  public SimpleFreecellModel() {

    gameStarted = false;
    gameEnded = false;
    foundationPiles = new ArrayList<List<IFreecellCard>>();
    cascadePiles = new ArrayList<List<IFreecellCard>>();
    openPiles = new ArrayList<List<IFreecellCard>>();
  }

  /**
   * Returns a valid and complete deck of cards for a game of Freecell. There is no restriction
   * imposed on the ordering of these cards in the deck. An invalid deck is defined as a deck that
   * has one or more of these flaws: <ul>
   * <li>It does not have 52 cards</li> <li>It has duplicate cards</li> <li>It
   * has at least one invalid card (invalid suit or invalid number) </li> </ul>
   *
   * @return the deck of cards as a list
   */
  @Override
  public List<IFreecellCard> getDeck() {
    List<IFreecellCard> cards = new ArrayList<IFreecellCard>();
    for (String suite : SUITES) {
      for (int value = 1; value <= 13; value++) {
        IFreecellCard c = new FreecellCardImpl(suite, value);
        cards.add(c);
      }
    }
    return cards;
  }

  /**
   * Deals a new game of freecell with the given deck, with or without shuffling it first. This
   * method first verifies that the deck is valid. It deals the deck among the cascade piles in
   * roundrobin fashion. Thus if there are 4 cascade piles, the 1st pile will get cards 0, 4, 8,
   * ..., the 2nd pile will get cards 1, 5, 9, ..., the 3rd pile will get cards 2, 6, 10, ... and
   * the 4th pile will get cards 3, 7, 11, .... Depending on the number of cascade piles, they may
   * have a different number of cards.
   *
   * @param numCascadePiles number of cascade piles
   * @param numOpenPiles    number of open piles
   * @param deck            the deck to be dealt
   * @param shuffle         if true, shuffle the deck else deal the deck as-is
   * @throws IllegalArgumentException if the deck is invalid
   */
  @Override
  public void startGame(List<IFreecellCard> deck, int numCascadePiles, int numOpenPiles,
      boolean shuffle) throws IllegalArgumentException {
    cascadePiles.clear();
    openPiles.clear();
    foundationPiles.clear();
    if (numCascadePiles < 4) {
      throw new IllegalArgumentException("Invalid number of cascade piles");
    }
    if (numOpenPiles < 1) {
      throw new IllegalArgumentException("Invalid number of open piles");
    }
    if (!isValidDeck(deck)) {
      throw new IllegalArgumentException("Invalid deck");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }
    for (int i = 0; i < 4; i++) {
      foundationPiles.add(new ArrayList<IFreecellCard>());
    }
    for (int i = 0; i < numCascadePiles; i++) {
      cascadePiles.add(new ArrayList<IFreecellCard>());
    }
    for (int i = 0; i < numOpenPiles; i++) {
      openPiles.add(new ArrayList<IFreecellCard>());
    }
    int i = 0;
    for (int pileIndex = 0; pileIndex < numCascadePiles && i <= deck.size() - 1;
        pileIndex = (pileIndex + 1) % numCascadePiles) {
      IFreecellCard c = deck.get(i);
      cascadePiles.get(pileIndex).add(c);
      i++;
    }
    gameStarted = true;
  }

  // Documented changes: I broke up my move method into helper methods since it was too long.

  /**
   * Helper method for the move method for when the open pile is the source pile.
   *
   * @param pileNumber the pile number of the given type, starting at 0
   * @param cardIndex  the index of the card to be moved from the source pile, starting at 0
   * @throws IllegalArgumentException if the provided card index is out of range or if the source
   *                                  pile is empty
   */
  protected void openIsSource(int pileNumber, int cardIndex) {
    // All cards in the open pile have an index of 0, meaning only one card must be in
    // the source pile.
    if (cardIndex != 0) {
      throw new IllegalArgumentException("cardIndex out of range");
    }
    cardToMove = getOpenCardAt(pileNumber);
    // Cannot move a card from the open pile if there are no cards.
    if (cardToMove == null) {
      throw new IllegalArgumentException("source pile is empty!");
    }
    sourcePile = openPiles.get(pileNumber);
  }

  /**
   * Helper method for the move method for when the cascade pile is the source pile.
   *
   * @param pileNumber the pile number of the given type, starting at 0
   * @param cardIndex  the index of the card to be moved from the source pile, starting at 0
   * @throws IllegalArgumentException if the provided card index is invalid
   */
  private void cascadeIsSource(int pileNumber, int cardIndex) {
    int numCascadeCards = getNumCardsInCascadePile(pileNumber);
    // The card to be moved has to be the very top card of the cascade pile.
    if (cardIndex != (numCascadeCards - 1)) {
      throw new IllegalArgumentException("invalid cardIndex");
    }
    cardToMove = getCascadeCardAt(pileNumber, cardIndex);
    sourcePile = cascadePiles.get(pileNumber);
  }

  /**
   * Helper method for the move method for when the cascade pile is the destination pile.
   *
   * @param destPileNumber the pile number of the given type, starting at 0
   * @param cardToMove     the card that is moving
   * @throws IllegalArgumentException if a move is invalid
   */
  protected void cascadeIsDestination(int destPileNumber, IFreecellCard cardToMove) {
    int numCards = getNumCardsInCascadePile(destPileNumber);
    if (numCards > 0) {
      IFreecellCard lastCardDest = getCascadeCardAt(destPileNumber, numCards - 1);
      // cards moves to the cascade pile must be one less than the value of the top card at the
      // cascade pile.
      if (cardToMove.getValue() != (lastCardDest.getValue() - 1)) {
        throw new IllegalArgumentException("invalid move");
      }
      // cards moves to the cascade pile must be the opposite color of the top card at the
      // cascade pile.
      if (cardToMove.getColor().equals(lastCardDest.getColor())) {
        throw new IllegalArgumentException("invalid move");
      }
    }
    destPile = cascadePiles.get(destPileNumber);
  }

  /**
   * Helper method for the move method for when the open pile is the destination pile.
   *
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if a move is invalid
   */
  protected void openIsDestination(int destPileNumber) {
    int numCards = getNumCardsInOpenPile(destPileNumber);
    // there can only be one card in an open pile.
    if (numCards > 0) {
      throw new IllegalArgumentException("invalid move");
    }
    destPile = openPiles.get(destPileNumber);
  }

  /**
   * Helper method for the move method for when the foundation pile is the destination pile.
   *
   * @param destPileNumber the pile number of the given type, starting at 0
   * @param cardToMove     the card that is moving
   * @throws IllegalArgumentException if a move is invalid
   */
  protected void foundationIsDestination(int destPileNumber, IFreecellCard cardToMove) {
    int numCards = getNumCardsInFoundationPile(destPileNumber);
    // foundation piles can only have a maximum of 13 cards (13 cards for each suite).
    if (numCards >= 13) {
      throw new IllegalArgumentException("invalid move");
    }
    if (numCards > 0) {
      IFreecellCard lastCardDest = getFoundationCardAt(destPileNumber, numCards - 1);
      // cards placed into a foundation pile has to be the same suite.
      if (!cardToMove.getSuite().equals(lastCardDest.getSuite())) {
        throw new IllegalArgumentException("invalid move");
      }
      // cards placed into a foundation pile has to be one greater than the value of the card
      // at the top of the foundation pile.
      if (cardToMove.getValue() != (lastCardDest.getValue() + 1)) {
        throw new IllegalArgumentException("invalid move");
      }
    }
    destPile = foundationPiles.get(destPileNumber);
  }


  /**
   * Moves a card from the given source pile to the given destination pile, if the move is valid.
   *
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   * @throws IllegalArgumentException if the move is not possible {@link PileType})
   * @throws IllegalStateException    if a move is attempted before the game has starts
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) throws IllegalArgumentException, IllegalStateException {
    cardToMove = null;
    sourcePile = null;
    destPile = null;
    if (!gameStarted) {
      throw new IllegalStateException("Cannot move before game has started.");
    }
    // conditions if the source pile is the open pile.
    if (source == PileType.OPEN) {
      openIsSource(pileNumber, cardIndex);
    }
    // conditions if the source pile is the cascade pile.
    else if (source == PileType.CASCADE) {
      cascadeIsSource(pileNumber, cardIndex);
    }
    // cards placed into foundation piles cannot be moved.
    else {
      throw new IllegalArgumentException("Cards cannot be moved from foundation pile!");
    }

    // conditions if the destination pile is the cascade pile.
    if (destination == PileType.CASCADE) {
      cascadeIsDestination(destPileNumber, cardToMove);
    }

    // conditions if the destination pile is the open pile.
    else if (destination == PileType.OPEN) {
      openIsDestination(destPileNumber);
    }

    // conditions if the destination pile is the foundation pile.
    else {
      foundationIsDestination(destPileNumber, cardToMove);
    }

    destPile.add(sourcePile.remove(cardIndex));
    int numFPileFull = 0;
    for (List<IFreecellCard> pile : foundationPiles) {
      if (pile.size() == 13) {
        numFPileFull++;
      }
    }
    gameEnded = (numFPileFull == foundationPiles.size());
  }

  /**
   * Signals if the game is over or not.
   *
   * @return true if game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return gameEnded;
  }

  /**
   * Helper method to get the number of cards in a pile.
   *
   * @param index    index of the pile
   * @param pileType the pile type; either foundation, cascade, or open pile
   * @return the number of cards in the pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  private int getNumCardsInAPile(int index, List<List<IFreecellCard>> pileType) {
    if (!gameStarted) {
      throw new IllegalStateException("Freecell Game not yet started!");
    }
    int numPiles = pileType.size();
    if (index < 0 || index >= numPiles) {
      throw new IllegalArgumentException("index out of range");
    }
    return pileType.get(index).size();
  }

  /**
   * Gets the number of cards in a given foundation pile.
   *
   * @param index the index of the foundation pile, starting at 0
   * @return the number of cards in the given foundation pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInFoundationPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInAPile(index, foundationPiles);
  }

  /**
   * Gets the number of cards in a given cascade pile.
   *
   * @param index the index of the cascade pile, starting at 0
   * @return the number of cards in the given cascade pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInCascadePile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInAPile(index, cascadePiles);
  }


  /**
   * Gets the number of cards in a given open pile.
   *
   * @param index the index of the open pile, starting at 0
   * @return the number of cards in the given open pile
   * @throws IllegalArgumentException if the provided index is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public int getNumCardsInOpenPile(int index)
      throws IllegalArgumentException, IllegalStateException {
    return getNumCardsInAPile(index, openPiles);
  }

  /**
   * Gets the number of cascade piles in this game of freecell.
   *
   * @return the number of cascade piles, as an integer, or -1 if the game has not started yet
   */
  @Override
  public int getNumCascadePiles() {
    if (!gameStarted) {
      return -1;
    } else {
      return cascadePiles.size();
    }
  }

  /**
   * Gets the number of open piles in this game of freecell.
   *
   * @return the number of open piles, as an integer, or -1 if the game has not started yet
   */
  @Override
  public int getNumOpenPiles() {
    if (!gameStarted) {
      return -1;
    } else {
      return openPiles.size();
    }
  }

  /**
   * Gets the card at the provided index in the provided foundation pile.
   *
   * @param pileIndex the index of the foundation pile, starting at 0
   * @param cardIndex the index of the card in the above foundation pile, starting at 0
   * @return the card at the provided indices
   * @throws IllegalArgumentException if the pileIndex or cardIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public IFreecellCard getFoundationCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    if (!gameStarted) {
      throw new IllegalStateException("Game not yet started!");
    }
    if (pileIndex < 0 || pileIndex >= 4) {
      throw new IllegalArgumentException("pileIndex out of range");
    }
    int numFoundationCards = foundationPiles.get(pileIndex).size();
    if (cardIndex < 0 || cardIndex >= numFoundationCards) {
      throw new IllegalArgumentException("cardIndex out of range");
    }
    return foundationPiles.get(pileIndex).get(cardIndex);
  }

  /**
   * Gets the card at the provided index in the provided cascade pile.
   *
   * @param pileIndex the index of the cascade pile, starting at 0
   * @param cardIndex the index of the card in the above cascade pile, starting at 0
   * @return the card at the provided indices
   * @throws IllegalArgumentException if the pileIndex or cardIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public IFreecellCard getCascadeCardAt(int pileIndex, int cardIndex)
      throws IllegalArgumentException, IllegalStateException {
    if (!gameStarted) {
      throw new IllegalStateException("Game not yet started!");
    }
    int numCascadePiles = cascadePiles.size();
    if (pileIndex < 0 || pileIndex >= numCascadePiles) {
      throw new IllegalArgumentException("pileIndex out of range");
    }
    int numCascadeCards = cascadePiles.get(pileIndex).size();
    if (cardIndex < 0 || cardIndex >= numCascadeCards) {
      throw new IllegalArgumentException("cardIndex out of range");
    }
    return cascadePiles.get(pileIndex).get(cardIndex);
  }

  /**
   * Gets the card in the given open pile.
   *
   * @param pileIndex the index of the open pile, starting at 0
   * @return the card at the provided index, or null if there is no card there
   * @throws IllegalArgumentException if the pileIndex is invalid
   * @throws IllegalStateException    if the game has not started
   */
  @Override
  public IFreecellCard getOpenCardAt(int pileIndex)
      throws IllegalArgumentException, IllegalStateException {
    if (!gameStarted) {
      throw new IllegalStateException("Game not yet started!");
    }
    int numOpenPiles = openPiles.size();
    if (pileIndex < 0 || pileIndex >= numOpenPiles) {
      throw new IllegalArgumentException("pileIndex out of range");
    }
    if (openPiles.get(pileIndex).isEmpty()) {
      return null;
    }
    return openPiles.get(pileIndex).get(0);
  }

  /**
   * Checks for the validity of a give deck of cards.
   *
   * @param deck A List of FreecellCard representing the deck
   * @return true if deck is valid, otherwise return false
   */
  protected boolean isValidDeck(List<IFreecellCard> deck) {
    Set<IFreecellCard> processed = new HashSet<IFreecellCard>();
    if (deck.size() != 52) {
      return false;
    }
    for (IFreecellCard c : deck) {
      if (!isValidSuite(c.getSuite()) || !isValidNumber(c.getValue())) {
        return false;
      }
      if (processed.contains(c)) {
        return false;
      }
      processed.add(c);
    }
    return true;
  }

  /**
   * Checks for the validity of a card suite. A suite can be one of the following "Hearts",
   * "Diamonds","Clubs","Spades".
   *
   * @param suite The suite of a card
   * @return true if suite is valid, otherwise return false
   */
  protected boolean isValidSuite(String suite) {
    for (String validSuite : SUITES) {
      if (suite.equals(validSuite)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks for the validity of a card number. A card number can range from 1 to 13.
   *
   * @param number The number of the card
   * @return true if number is valid, otherwise return false
   */
  protected boolean isValidNumber(int number) {
    return (number >= 1 && number <= 13);
  }

}
