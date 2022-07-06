import static org.junit.Assert.assertEquals;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.FreecellCardImpl;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * An extended test class for the MultiMoveFreecellModel class and tests the model along with the
 * controller. This class only tests multi-moves.
 */
public class MultiMoveFreecellExtendedTest {

  // an arraylist for the deck of cards used for all the test methods.
  List<IFreecellCard> l1 = new ArrayList<>();

  // MultiMoveFreecellModel used for all test methods.
  FreecellModel<IFreecellCard> gameModel = new MultiMoveFreecellModel();

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

  // the following tests test the MultiFreecellModel model

  // tests a valid multi-move with sufficient free open piles
  @Test
  public void correctlyTestsAValidMultiMove() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // Multi-move made here to cascade pile 6 with 2 cards in multi-move
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    assertEquals("F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
  }


  // tests a valid multi-move with sufficient free open piles
  @Test
  public void correctlyTestsAValidMultiMove2() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥, 8♠\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // Multi-move made here to cascade pile 7 with 4 cards in multi-move
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: J♥, 10♣, 9♥, 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
  }

  // tests a valid multi-move with sufficient free cascade piles
  @Test
  public void correctlyTestsAValidMultiMove3() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    // filling up open piles
    gameModel.move(PileType.CASCADE, 2, 6, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 2, 3, PileType.OPEN, 3);
    // one free cascade pile
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4: 3♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥, 8♠\n"
        + "C3: J♦, J♠, 5♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // 2 cards in multi-move
    gameModel.move(PileType.CASCADE, 1, 7, PileType.CASCADE, 6);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4: 3♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣\n"
        + "C3: J♦, J♠, 5♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 9♥, 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
  }


  // tests a valid multi-move with sufficient free cascade and open piles
  @Test
  public void correctlyTestsAValidMultiMove4() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    // filling up only 2 open piles with 2 open piles left
    gameModel.move(PileType.CASCADE, 2, 6, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.OPEN, 1);
    // one free cascade pile
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥, 8♠\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // 4 cards in multi-move
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: J♥, 10♣, 9♥, 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
  }


  // Disallows an invalid build of cards in a multi-move
  @Test(expected = IllegalArgumentException.class)
  public void MultiMoveDisallowsInvalidBuildOfCards() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    // mulitmove
    gameModel.move(PileType.CASCADE, 6, 3, PileType.CASCADE, 5);
  }


  // Multi-move cannot be made if there's not enough free intermediate piles
  @Test(expected = IllegalArgumentException.class)
  public void InsufficientFreeOpenPilesDisallowsMultiMove() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    // filling up open piles
    gameModel.move(PileType.CASCADE, 1, 5, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 1, 3, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 1, 2, PileType.OPEN, 3);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: J♥\n"
        + "O2: A♥\n"
        + "O3: 9♣\n"
        + "O4: J♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // 2 cards in mulit-move
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
  }

  // Multi-move cannot be made if there's not enough free intermediate piles (open/cascade)
  @Test(expected = IllegalArgumentException.class)
  public void InsufficientFreeCascadePilesDisallowsMultiMove() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    // mulitmove
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    // multimove
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    // one free cascade pile
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    // filling up open piles
    gameModel.move(PileType.CASCADE, 2, 6, PileType.OPEN, 0);
    gameModel.move(PileType.CASCADE, 2, 5, PileType.OPEN, 1);
    gameModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 2);
    gameModel.move(PileType.CASCADE, 2, 3, PileType.OPEN, 3);
    FreecellView f1 = new FreecellTextView(gameModel);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4: 3♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥, 8♠\n"
        + "C3: J♦, J♠, 5♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
    // 4 cards in multi-move
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
  }


  // correctly tests if game is over
  @Test
  public void correctlyTestsGameOver() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    // mulitmove
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    // multimove
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    // multimove
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    gameModel.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    // multimove
    gameModel.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
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

  // correctly tests if game is not over
  @Test
  public void correctlyTestsThatGameIsNotOver() {
    gameModel.startGame(l1, 8, 4, false);
    gameModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    gameModel.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    // mulitmove
    gameModel.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    // multimove
    gameModel.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    gameModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    gameModel.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    // multimove
    gameModel.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    gameModel.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    gameModel.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    gameModel.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    // multimove
    gameModel.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
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
    assertEquals(false, gameModel.isGameOver());
  }

  // the following tests test the model with the controller

  // tests a valid multi-move with sufficient free open piles
  @Test
  public void testsAValidMultiMoveWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 5 C6 q"); // multi-move
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
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
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠, A♣\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "Game quit prematurely.", out.toString());
  }

  // tests a valid multi-move with sufficient free cascade piles
  @Test
  public void testsAValidMultiMoveWithController2() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 5 C6 "
        + "C7 3 C2 "
        + "C7 2 F2 "
        + "C3 7 O1 "
        + "C3 6 O2 "
        + "C3 5 O3 "
        + "C3 4 O4 "
        + "C7 1 C2 q"); //multi-move with one free cascade pile
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
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
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠, A♣\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣, 3♦\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠, 2♣\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣, 3♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4: 3♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥\n"
        + "C3: J♦, J♠, 5♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: 8♠\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: Q♥\n"
        + "O2: 2♦\n"
        + "O3: K♣\n"
        + "O4: 3♣\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥, 10♣, 9♥, 8♠\n"
        + "C3: J♦, J♠, 5♣\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "Game quit prematurely.", out.toString());
  }


  // tests an invalid build of cards
  @Test
  public void InvalidBuildOfCardsDisallowsMultiMoveWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 4 C6 q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals(true, out.toString().contains("\nInvalid move. Try again.\n"));
  }

  // cannot make move if there's not enough free open piles
  @Test
  public void InsufficientFreeOpenPilesDisallowsMultiMoveWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C2 6 O1 "
        + "C2 5 O2 "
        + "C2 4 O3 "
        + "C2 3 O4 "
        + "C7 5 C6 q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals(true, out.toString().contains("\nInvalid move. Try again.\n"));
  }


  // cannot make move if there's not enough free cascade piles
  @Test
  public void InsufficientFreeCascadePilesDisallowsMultiMoveWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 5 C6 "
        + "C7 3 C2 "
        + "C7 2 F2 "
        + "C7 1 C2 " // free cascade pile open
        + "C1 7 O1 " // filling up open piles
        + "C1 6 O2 "
        + "C1 5 O3 "
        + "C1 4 O4 "
        + "C2 6 C7 q"); // multi-move
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals(true, out.toString().contains("\nInvalid move. Try again.\n"));
  }

  // tests that game is not over
  @Test
  public void testsGameIsNotOverWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 5 C6 " // multi-move
        + "C7 3 C2 " // multi-move
        + "C7 2 F2 "
        + "C7 1 C2 "
        + "C2 6 C7 " // multi-move
        + "C2 5 F1 "
        + "C5 6 O4 "
        + "C5 5 C7 "
        + "C5 4 F1 "
        + "C6 6 C7 " // multimove
        + "C6 5 F4 "
        + "C1 7 O3 "
        + "C1 6 F1 "
        + "C6 4 C1 "
        + "C4 6 C1 "
        + "C4 5 F1 "
        + "C4 4 F1 "
        + "C4 3 C1 "
        + "C4 2 F3 "
        + "C4 1 C5 "
        + "C3 7 C4 "
        + "C3 6 F3 "
        + "C7 9 F3 "
        + "C8 5 F4 "
        + "C3 5 O2 "
        + "C3 4 F2 "
        + "C1 8 F3 "
        + "C7 8 F2 "
        + "C3 3 F2 "
        + "C6 3 O1 "
        + "C6 2 F4 "
        + "C1 7 F4 "
        + "C1 6 F1 "
        + "C7 7 F3 "
        + "C7 6 F4 "
        + "C8 4 F2 "
        + "C8 3 F1 "
        + "O3 1 F3 "
        + "C1 5 F4 "
        + "C7 5 F3 "
        + "C7 4 F4 "
        + "C8 2 F2 "
        + "C1 4 F2 "
        + "C5 4 F1 "
        + "C7 3 F1 "
        + "C5 3 F4 "
        + "C5 2 F3 "
        + "C2 4 F2 "
        + "C1 3 F1 "
        + "O4 1 F3 "
        + "C1 2 F4 "
        + "C6 1 F3 "
        + "C3 2 F4 "
        + "C7 2 F2 "
        + "C2 3 F2 "
        + "C3 1 F3 "
        + "C5 1 F3 "
        + "C7 1 F1 "
        + "C1 1 F4 "
        + "C4 1 F1 "
        + "C2 2 F4 "
        + "O1 1 F2 "
        + "C2 1 F1 "
        + "C8 1 F3 q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    FreecellTextView f1 = new FreecellTextView(gameModel);
    assertEquals(false, out.toString().contains("\nGame over.\n"));
  }

  // tests that the game over render message successfully is transmitted when the game is over
  @Test
  public void testsGameIsOverWithController() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 5 C6 " // multi-move
        + "C7 3 C2 " // multi-move
        + "C7 2 F2 "
        + "C7 1 C2 "
        + "C2 6 C7 " // multi-move
        + "C2 5 F1 "
        + "C5 6 O4 "
        + "C5 5 C7 "
        + "C5 4 F1 "
        + "C6 6 C7 " // multimove
        + "C6 5 F4 "
        + "C1 7 O3 "
        + "C1 6 F1 "
        + "C6 4 C1 "
        + "C4 6 C1 "
        + "C4 5 F1 "
        + "C4 4 F1 "
        + "C4 3 C1 "
        + "C4 2 F3 "
        + "C4 1 C5 "
        + "C3 7 C4 "
        + "C3 6 F3 "
        + "C7 9 F3 "
        + "C8 5 F4 "
        + "C3 5 O2 "
        + "C3 4 F2 "
        + "C1 8 F3 "
        + "C7 8 F2 "
        + "C3 3 F2 "
        + "C6 3 O1 "
        + "C6 2 F4 "
        + "C1 7 F4 "
        + "C1 6 F1 "
        + "C7 7 F3 "
        + "C7 6 F4 "
        + "C8 4 F2 "
        + "C8 3 F1 "
        + "O3 1 F3 "
        + "C1 5 F4 "
        + "C7 5 F3 "
        + "C7 4 F4 "
        + "C8 2 F2 "
        + "C1 4 F2 "
        + "C5 4 F1 "
        + "C7 3 F1 "
        + "C5 3 F4 "
        + "C5 2 F3 "
        + "C2 4 F2 "
        + "C1 3 F1 "
        + "O4 1 F3 "
        + "C1 2 F4 "
        + "C6 1 F3 "
        + "C3 2 F4 "
        + "C7 2 F2 "
        + "C2 3 F2 "
        + "C3 1 F3 "
        + "C5 1 F3 "
        + "C7 1 F1 "
        + "C1 1 F4 "
        + "C4 1 F1 "
        + "C2 2 F4 "
        + "O1 1 F2 "
        + "C2 1 F1 "
        + "C8 1 F3 "
        + "O2 1 F2 "
        + "q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    FreecellTextView f1 = new FreecellTextView(gameModel);
    assertEquals(true, out.toString().contains("\nGame over.\n"));
  }


}
