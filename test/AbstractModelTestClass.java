import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.hw02.FreecellCardImpl;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract test class for the SimpleFreecellModel class and the MultiMoveFreecellModel class.
 * Tests are made to ensure that the game is carried out correctly. This test class was originally
 * made for the SimpleFreecellModel class. All test cases for the SimpleFreecellModel class should
 * also work for the MultiMoveFreecellModel class.
 */
public abstract class AbstractModelTestClass {

  // the game model, either a SimpleFreecellModel or a MultiMoveFreecellModel
  FreecellModel<IFreecellCard> gameModel;

  @Before
  public void setUp() throws Exception {
    gameModel = makeModel();
  }

  public abstract FreecellModel<IFreecellCard> makeModel();

  /**
   * The test class for the SimpleFreecellModel class.
   */
  public static class SimpleFreecellModelTest extends AbstractModelTestClass {
    @Override
    public FreecellModel<IFreecellCard> makeModel() {
      return new SimpleFreecellModel();
    }
  }

  /**
   * The test class for the MultiMoveFreecellModel class.
   */
  public static class MultiMoveFreecellModelTest extends AbstractModelTestClass {
    @Override
    public FreecellModel<IFreecellCard> makeModel() {
      return new MultiMoveFreecellModel();
    }
  }

  // an arraylist for the deck of cards used for all the test methods.
  List<IFreecellCard> l1 = new ArrayList<>();

  // all the cards in the l1 list
  @Before
  public void deckOfCards() {
    l1.add(new FreecellCardImpl("Spades", 12));
    l1.add(new FreecellCardImpl("Hearts", 13));
    l1.add(new FreecellCardImpl("Diamonds", 11));
    l1.add(new FreecellCardImpl("Hearts", 8));
    l1.add(new FreecellCardImpl("Diamonds", 12));
    l1.add(new FreecellCardImpl("Diamonds", 10));
    l1.add(new FreecellCardImpl("Spades", 8));
    l1.add(new FreecellCardImpl("Diamonds", 13));

    l1.add(new FreecellCardImpl("Spades", 10));
    l1.add(new FreecellCardImpl("Spades", 13));
    l1.add(new FreecellCardImpl("Spades", 11));
    l1.add(new FreecellCardImpl("Diamonds", 1));
    l1.add(new FreecellCardImpl("Diamonds", 8));
    l1.add(new FreecellCardImpl("Spades", 4));
    l1.add(new FreecellCardImpl("Clubs", 2));
    l1.add(new FreecellCardImpl("Clubs", 7));

    l1.add(new FreecellCardImpl("Hearts", 10));
    l1.add(new FreecellCardImpl("Clubs", 11));
    l1.add(new FreecellCardImpl("Clubs", 5));
    l1.add(new FreecellCardImpl("Diamonds", 4));
    l1.add(new FreecellCardImpl("Spades", 9));
    l1.add(new FreecellCardImpl("Clubs", 12));
    l1.add(new FreecellCardImpl("Clubs", 10));
    l1.add(new FreecellCardImpl("Hearts", 7));

    l1.add(new FreecellCardImpl("Clubs", 8));
    l1.add(new FreecellCardImpl("Clubs", 9));
    l1.add(new FreecellCardImpl("Clubs", 3));
    l1.add(new FreecellCardImpl("Hearts", 5));
    l1.add(new FreecellCardImpl("Hearts", 2));
    l1.add(new FreecellCardImpl("Hearts", 6));
    l1.add(new FreecellCardImpl("Hearts", 9));
    l1.add(new FreecellCardImpl("Clubs", 6));

    l1.add(new FreecellCardImpl("Spades", 7));
    l1.add(new FreecellCardImpl("Hearts", 1));
    l1.add(new FreecellCardImpl("Clubs", 13));
    l1.add(new FreecellCardImpl("Hearts", 4));
    l1.add(new FreecellCardImpl("Diamonds", 7));
    l1.add(new FreecellCardImpl("Spades", 2));
    l1.add(new FreecellCardImpl("Clubs", 4));
    l1.add(new FreecellCardImpl("Spades", 3));

    l1.add(new FreecellCardImpl("Hearts", 3));
    l1.add(new FreecellCardImpl("Hearts", 11));
    l1.add(new FreecellCardImpl("Diamonds", 2));
    l1.add(new FreecellCardImpl("Spades", 5));
    l1.add(new FreecellCardImpl("Diamonds", 9));
    l1.add(new FreecellCardImpl("Spades", 6));
    l1.add(new FreecellCardImpl("Diamonds", 3));
    l1.add(new FreecellCardImpl("Spades", 1));

    l1.add(new FreecellCardImpl("Diamonds", 6));
    l1.add(new FreecellCardImpl("Diamonds", 5));
    l1.add(new FreecellCardImpl("Hearts", 12));
    l1.add(new FreecellCardImpl("Clubs", 1));
  }

  // tests getDeck()
  @Test
  public void getsAValidDeck() {
    List<FreecellCardImpl> l2 = new ArrayList<FreecellCardImpl>();
    l2.add(new FreecellCardImpl("Hearts", 1));
    l2.add(new FreecellCardImpl("Hearts", 2));
    l2.add(new FreecellCardImpl("Hearts", 3));
    l2.add(new FreecellCardImpl("Hearts", 4));
    l2.add(new FreecellCardImpl("Hearts", 5));
    l2.add(new FreecellCardImpl("Hearts", 6));
    l2.add(new FreecellCardImpl("Hearts", 7));
    l2.add(new FreecellCardImpl("Hearts", 8));
    l2.add(new FreecellCardImpl("Hearts", 9));
    l2.add(new FreecellCardImpl("Hearts", 10));
    l2.add(new FreecellCardImpl("Hearts", 11));
    l2.add(new FreecellCardImpl("Hearts", 12));
    l2.add(new FreecellCardImpl("Hearts", 13));
    l2.add(new FreecellCardImpl("Diamonds", 1));
    l2.add(new FreecellCardImpl("Diamonds", 2));
    l2.add(new FreecellCardImpl("Diamonds", 3));
    l2.add(new FreecellCardImpl("Diamonds", 4));
    l2.add(new FreecellCardImpl("Diamonds", 5));
    l2.add(new FreecellCardImpl("Diamonds", 6));
    l2.add(new FreecellCardImpl("Diamonds", 7));
    l2.add(new FreecellCardImpl("Diamonds", 8));
    l2.add(new FreecellCardImpl("Diamonds", 9));
    l2.add(new FreecellCardImpl("Diamonds", 10));
    l2.add(new FreecellCardImpl("Diamonds", 11));
    l2.add(new FreecellCardImpl("Diamonds", 12));
    l2.add(new FreecellCardImpl("Diamonds", 13));
    l2.add(new FreecellCardImpl("Clubs", 1));
    l2.add(new FreecellCardImpl("Clubs", 2));
    l2.add(new FreecellCardImpl("Clubs", 3));
    l2.add(new FreecellCardImpl("Clubs", 4));
    l2.add(new FreecellCardImpl("Clubs", 5));
    l2.add(new FreecellCardImpl("Clubs", 6));
    l2.add(new FreecellCardImpl("Clubs", 7));
    l2.add(new FreecellCardImpl("Clubs", 8));
    l2.add(new FreecellCardImpl("Clubs", 9));
    l2.add(new FreecellCardImpl("Clubs", 10));
    l2.add(new FreecellCardImpl("Clubs", 11));
    l2.add(new FreecellCardImpl("Clubs", 12));
    l2.add(new FreecellCardImpl("Clubs", 13));
    l2.add(new FreecellCardImpl("Spades", 1));
    l2.add(new FreecellCardImpl("Spades", 2));
    l2.add(new FreecellCardImpl("Spades", 3));
    l2.add(new FreecellCardImpl("Spades", 4));
    l2.add(new FreecellCardImpl("Spades", 5));
    l2.add(new FreecellCardImpl("Spades", 6));
    l2.add(new FreecellCardImpl("Spades", 7));
    l2.add(new FreecellCardImpl("Spades", 8));
    l2.add(new FreecellCardImpl("Spades", 9));
    l2.add(new FreecellCardImpl("Spades", 10));
    l2.add(new FreecellCardImpl("Spades", 11));
    l2.add(new FreecellCardImpl("Spades", 12));
    l2.add(new FreecellCardImpl("Spades", 13));
    assertEquals(l2, gameModel.getDeck());
  }

  // startGame() does not run if the number of cascade piles to be less than 4
  @Test(expected = IllegalArgumentException.class)
  public void doesNotStartGameIfCascadePilesIsLessThanFour() {
    gameModel.startGame(l1, 2, 3, true);
  }

  // startGame() does not run if the number of open piles to be less than 1
  @Test(expected = IllegalArgumentException.class)
  public void doesNotStartGameIfOpenPilesIsLessThanOne() {
    List<IFreecellCard> l1 = gameModel.getDeck();
    gameModel.startGame(l1, 2, 0, true);
  }

  // startGame() does not run if there is an invalid deck
  @Test(expected = IllegalArgumentException.class)
  public void doesNotStartGameWithInvalidDeck() {
    SimpleFreecellModel s1 = new SimpleFreecellModel();
    List<IFreecellCard> l1 = new ArrayList<>();
    l1.add(new FreecellCardImpl("♥", 1));
    l1.add(new FreecellCardImpl("♥", 1));
    s1.startGame(l1, 4, 3, true);
  }

  // move() does not run if game didn't start yet
  @Test(expected = IllegalStateException.class)
  public void cannotMoveIfGameDidNotStart() {
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
  }

  // move() does not run if the card index at an open pile is not 0, because
  // that means there's either more than one card or a negative number at the open pile.
  @Test(expected = IllegalArgumentException.class)
  public void openPileDisallowsCardIndexThatIsNotZero() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 1, PileType.CASCADE, 5);
  }

  // move() does not run if the source pile is the open pile, and there are no cards in
  // the open pile.
  @Test(expected = IllegalArgumentException.class)
  public void emptyOpenPileDisallowsMoves() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 5);
  }

  // move() does not run if the a player attempts to move a card from the cascade pile that isn't
  // the card on top.
  @Test(expected = IllegalArgumentException.class)
  public void cannotMoveCardsThatAreNotTheTopCascadePileCard() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 5);
  }

  // move() does not run if the a player attempts to move a card from a foundation pile.
  @Test(expected = IllegalArgumentException.class)
  public void cardsCannotMoveFromFoundationPile() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 1);
    gameModel.move(PileType.FOUNDATION, 1, 0, PileType.OPEN, 0);
  }

  // move() does not run if a player attempts to move a card to a cascade pile while the card
  // is not one less than the value of the top card at the cascade pile.
  @Test(expected = IllegalArgumentException.class)
  public void cannotPutCardIntoCascadePileIfItIsNotOneLessThanValue() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 2);
  }

  // move() does not run if a player attempts to move a card to a cascade pile with the
  // same color on top.
  @Test(expected = IllegalArgumentException.class)
  public void cannotPutCardIntoCascadePileIfItIsNotDifferentColors() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 0);
  }

  // move() does not run if a player attempts to put two or more cards into the same
  // open pile at the same time.
  @Test(expected = IllegalArgumentException.class)
  public void openPileDisallowsMoreThanOneCard() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.OPEN, 0);
  }

  // move() does not run if a player attempts to put a card of a different suite into
  // a foundation pile.
  @Test(expected = IllegalArgumentException.class)
  public void foundationPilesDisallowsDifferentSuites() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 1);
  }

  // move() does not run if a player attempts to put a card that is not one more than the value
  // of the card on top of a foundation pile.
  @Test(expected = IllegalArgumentException.class)
  public void foundationPilesDisallowsCardsThatAreNotOneMoreThanValueOfTopCard() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
  }

  // move() does not run if there's going to be more than 13 cards in a foundation pile.
  @Test(expected = IllegalArgumentException.class)
  public void foundationPileCannotHaveMoreThan13Cards() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    gameModel.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    gameModel.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 3);
  }

  // tests isGameOver().
  @Test
  public void correctlyTestsIfGameIsOver() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    gameModel.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    gameModel.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
    assertEquals(true, gameModel.isGameOver());
  }


  // tests isGameOver().
  @Test
  public void returnsFalseIfGameIsNotOver() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    gameModel.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    gameModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    gameModel.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    gameModel.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    assertEquals(false, gameModel.isGameOver());
  }


  // tests getNumCardsInFoundationPile()
  @Test
  public void correctlyGetsNumCardsInFoundationPile() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    assertEquals(2, gameModel.getNumCardsInFoundationPile(1));
  }

  // tests getNumCardsInFoundationPile()
  @Test(expected = IllegalStateException.class)
  public void getsNumCardsInFoundationPileDisallowsStateWhereGameDidNotStart() {
    gameModel.getNumCardsInFoundationPile(1);
  }

  // tests getNumCardsInFoundationPile()
  @Test(expected = IllegalArgumentException.class)
  public void getsNumCardsInFoundationPileDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.getNumCardsInFoundationPile(-1);
  }


  // tests startGame()
  @Test
  public void correctlyRestartsGame() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.startGame(l1, 8, 4, false);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 5♦\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠, A♣\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠", f1.toString());
  }

  // tests getNumCardsInCascadePile()
  @Test
  public void correctlyGetsNumCardsInCascadePile() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    assertEquals(9, gameModel.getNumCardsInCascadePile(5));
  }

  // tests getNumCardsInCascadePile()
  @Test(expected = IllegalStateException.class)
  public void getsNumCardsInCascadePileDisallowsStateWhereGameDidNotStart() {
    gameModel.getNumCardsInCascadePile(5);
  }

  // tests getNumCardsInCascadePile()
  @Test(expected = IllegalArgumentException.class)
  public void getsNumCardsInCascadePileDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    assertEquals(9, gameModel.getNumCardsInCascadePile(-5));
    assertEquals(9, gameModel.getNumCardsInCascadePile(11));
  }

  // tests getNumCardsInOpenPile()
  @Test
  public void correctlyGetsNumCardsInOpenPile() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    assertEquals(1, gameModel.getNumCardsInOpenPile(0));
    assertEquals(0, gameModel.getNumCardsInOpenPile(2));
  }

  // tests getNumCardsInOpenPile()
  @Test(expected = IllegalStateException.class)
  public void getsNumCardsInOpenPileDisallowsStateWhereGameDidNotStart() {
    gameModel.getNumCardsInOpenPile(2);
  }

  // tests getNumCardsInOpenPile()
  @Test(expected = IllegalArgumentException.class)
  public void getsNumCardsInOpenPileDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.getNumCardsInOpenPile(-1);
    gameModel.getNumCardsInOpenPile(4);
  }


  // tests getNumCascadePiles() before the start of the game
  @Test
  public void correctlyGetsNumCascadePilesBeforeStartGame() {
    assertEquals(-1, gameModel.getNumCascadePiles());
  }


  // tests getNumCascadePiles()
  @Test
  public void correctlyGetsNumCascadePilesAfterShuffle() {
    List<IFreecellCard> l1 = gameModel.getDeck();
    gameModel.startGame(l1, 4, 3, false);
    assertEquals(4, gameModel.getNumCascadePiles());

    gameModel.startGame(l1, 4, 3, true);
    assertEquals(4, gameModel.getNumCascadePiles());

    gameModel.startGame(l1, 4, 3, false);
    assertEquals(4, gameModel.getNumCascadePiles());

    gameModel.startGame(l1, 4, 3, true);
    assertEquals(4, gameModel.getNumCascadePiles());
  }

  // tests getNumOpenPiles() before the start of the game
  @Test
  public void correctlyGetsNumOpenPilesBeforeStartGame() {
    assertEquals(-1, gameModel.getNumOpenPiles());
  }


  // tests getNumOpenPiles()
  @Test
  public void correctlyGetsNumOpenPilesAfterShuffle() {
    List<IFreecellCard> l1 = gameModel.getDeck();
    gameModel.startGame(l1, 4, 3, false);
    assertEquals(3, gameModel.getNumOpenPiles());

    gameModel.startGame(l1, 4, 3, true);
    assertEquals(3, gameModel.getNumOpenPiles());

    gameModel.startGame(l1, 4, 3, false);
    assertEquals(3, gameModel.getNumOpenPiles());

    gameModel.startGame(l1, 4, 3, true);
    assertEquals(3, gameModel.getNumOpenPiles());
  }


  // tests getFoundationCardAt()
  @Test
  public void correctlyGetsFoundationCardAtTheIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    assertEquals(new FreecellCardImpl("Clubs", 1), gameModel.getFoundationCardAt(1, 0));
    assertEquals(new FreecellCardImpl("Spades", 1), gameModel.getFoundationCardAt(3, 0));
  }

  // tests getFoundationCardAt()
  @Test(expected = IllegalStateException.class)
  public void getFoundationCardAtDisallowsStateWhereGameDidNotStart() {
    gameModel.getFoundationCardAt(3, 1);
  }

  // tests getFoundationCardAt()
  @Test(expected = IllegalArgumentException.class)
  public void getFoundationCardAtDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.getFoundationCardAt(1, 5);
    gameModel.getFoundationCardAt(3, -1);
  }

  // tests getCascadeCardAt()
  @Test
  public void correctlyGetsCascadeCardAtTheIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    assertEquals(new FreecellCardImpl("Hearts", 8), gameModel.getCascadeCardAt(3, 0));
    assertEquals(new FreecellCardImpl("Clubs", 6), gameModel.getCascadeCardAt(7, 3));
  }

  // tests getCascadeCardAt()
  @Test(expected = IllegalStateException.class)
  public void getCascadeCardAtDisallowsStateWhereGameDidNotStart() {
    gameModel.getCascadeCardAt(3, 1);
  }

  // tests getCascadeCardAt()
  @Test(expected = IllegalArgumentException.class)
  public void getCascadeCardAtDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.getCascadeCardAt(3, 13);
    gameModel.getCascadeCardAt(7, -2);
    gameModel.getCascadeCardAt(-1, 13);
    gameModel.getCascadeCardAt(12, 13);
  }

  // tests getOpenCardAt()
  @Test
  public void correctlyGetsOpenCardAtTheIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    assertEquals(new FreecellCardImpl("Hearts", 9), gameModel.getOpenCardAt(0));
  }

  // tests getOpenCardAt()
  @Test(expected = IllegalStateException.class)
  public void getOpenCardAtDisallowsStateWhereGameDidNotStart() {
    gameModel.getOpenCardAt(3);
  }

  // tests getOpenCardAt()
  @Test(expected = IllegalArgumentException.class)
  public void getOpenCardAtDisallowsInvalidIndex() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.getOpenCardAt(-1);
    gameModel.getOpenCardAt(2);
  }

}
