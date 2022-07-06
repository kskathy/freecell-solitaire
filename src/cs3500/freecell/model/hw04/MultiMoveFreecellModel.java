package cs3500.freecell.model.hw04;

import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import java.util.List;


/**
 * This class implements the interface FreeCellModel using an instance of FreecellCard as the
 * generic type for K for the multiple move version of the game.
 */
public class MultiMoveFreecellModel extends SimpleFreecellModel {

  /**
   * Class constructor for creating new SimpleFreecellModel instance that creates empty piles and
   * sets the game ended and started flag to false. The constructor inherits the constructor from
   * the super class, SimpleFreecellModel.
   */
  public MultiMoveFreecellModel() {
    super();
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
    // first card among the multiple cards to be moved
    IFreecellCard firstCardToMove = null;
    sourcePile = null;
    destPile = null;
    int numCardsToMove = 0;
    if (!gameStarted) {
      throw new IllegalStateException("Cannot move before game has started.");
    }

    // conditions if the source pile is an open pile.
    if (source == PileType.OPEN) {
      openIsSource(pileNumber, cardIndex);
      firstCardToMove = cardToMove;
      numCardsToMove = 1;
    }

    // conditions if the source pile is a cascade pile and either a single or multi-move is made
    else if (source == PileType.CASCADE) {
      int numCascadeCards = getNumCardsInCascadePile(pileNumber);
      // cannot move from an empty cascade pile
      if (numCascadeCards == 0) {
        throw new IllegalArgumentException("source pile is empty");
      }
      // check validity of source pile card index
      if (cardIndex < 0 || cardIndex >= numCascadeCards) {
        throw new IllegalArgumentException("invalid cardIndex");
      }
      // compute number of cards to be moved
      numCardsToMove = (numCascadeCards - cardIndex);
      cardToMove = getCascadeCardAt(pileNumber, cardIndex);
      sourcePile = cascadePiles.get(pileNumber);
      // validate all cards to be moved are in correct build
      IFreecellCard prevCard = sourcePile.get(cardIndex);
      firstCardToMove = prevCard;
      for (int i = 1; i < numCardsToMove; i++) {
        IFreecellCard nextCard = sourcePile.get(cardIndex + i);
        if (!((nextCard.getValue() == prevCard.getValue() - 1) && (!nextCard.getColor()
            .equals(prevCard.getColor())))) {
          throw new IllegalArgumentException("invalid build of cards to move");
        }
        prevCard = nextCard;
      }
    } else {
      throw new IllegalArgumentException("Cards cannot be moved from foundation pile!");
    }

    // conditions if the destination pile is the cascade pile.
    if (destination == PileType.CASCADE) {
      cascadeIsDestination(destPileNumber, firstCardToMove);
    }

    // conditions if the destination pile is the open pile.
    else if (destination == PileType.OPEN) {
      openIsDestination(destPileNumber);
      if (numCardsToMove > 1) {
        throw new IllegalArgumentException("invalid move");
      }
    }

    // conditions if the destination pile is the foundation pile.
    else {
      int numCards = getNumCardsInFoundationPile(destPileNumber);
      // only one card can be moved to a foundation pile
      if (numCardsToMove > 1) {
        throw new IllegalArgumentException("invalid move");
      }
      foundationIsDestination(destPileNumber, firstCardToMove);
    }
    // finally check the conditions of the maximum number of cards that can be moved
    // and if there aren't enough free intermediate slots
    // let N = getNumFreeOpenPiles();
    // let K = getNumFreeCascadePiles();
    // is (N + 1) * 2^K, where
    if (numCardsToMove > (getNumFreeOpenPiles() + 1) * Math.pow(2, getNumFreeCascadePiles())) {
      throw new IllegalArgumentException("Not enough intermediate slots available");
    }

    // Now, make the move to update the source and destination pile
    for (int i = cardIndex; i < sourcePile.size(); i++) {
      destPile.add(sourcePile.get(i));
    }
    for (int i = sourcePile.size() - 1; i >= cardIndex; i--) {
      sourcePile.remove(i);
    }
    // Check if game is over (all foundation piles are full)
    int numFPileFull = 0;
    for (List<IFreecellCard> pile : foundationPiles) {
      if (pile.size() == 13) {
        numFPileFull++;
      }
    }
    gameEnded = (numFPileFull == foundationPiles.size());
  }

  /**
   * Get the number of free open piles.
   *
   * @return the number of free open piles.
   */
  private int getNumFreeOpenPiles() {
    int count = 0;
    for (int i = 0; i < getNumOpenPiles(); i++) {
      if (getNumCardsInOpenPile(i) == 0) {
        count++;
      }
    }
    return count;
  }

  /**
   * Get the number of free cascade piles.
   *
   * @return the number of free cascade piles.
   */
  private int getNumFreeCascadePiles() {
    int count = 0;
    for (int i = 0; i < getNumCascadePiles(); i++) {
      if (getNumCardsInCascadePile(i) == 0) {
        count++;
      }
    }
    return count;
  }

}
