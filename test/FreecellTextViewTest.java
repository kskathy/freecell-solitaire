import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.FreecellCardImpl;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Test class for FreecellTextView. Tests are made to ensure that each model state is correctly
 * being outputted.
 */
public class FreecellTextViewTest {

  // an arraylist for the deck of cards used for all the test methods.
  List<IFreecellCard> l1 = new ArrayList<>();

  // simpleFreeCellModel used for all test methods.
  FreecellModel<IFreecellCard> s1 = new SimpleFreecellModel();

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

  // test for toString()
  @Test
  public void returnsEmptyStringIfGameDidNotStart() {
    FreecellView f1 = new FreecellTextView(s1);
    assertEquals("", f1.toString());
  }

  // test for toString()
  @Test
  public void correctlyOutputsTextViewOfStartingModel() {
    s1.startGame(l1, 8, 4, false);
    FreecellView f1 = new FreecellTextView(s1);
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


  // test for toString()
  @Test
  public void correctlyOutputsTextViewDuringMiddleOfGame() {
    s1.startGame(l1, 8, 4, false);
    s1.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    FreecellView f1 = new FreecellTextView(s1);
    assertEquals("F1:\n"
        + "F2: A♣, 2♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: 8♠\n"
        + "O2: 9♥\n"
        + "O3: 10♣\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣, 3♦\n"
        + "C7: \n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠", f1.toString());
  }

  // test for toString()
  @Test
  public void correctlyOutputsTextViewAtEndOfGame() {
    s1.startGame(l1, 8, 4, false);
    s1.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    s1.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    s1.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    s1.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
    FreecellView f1 = new FreecellTextView(s1);
    assertEquals("F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F2: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F3: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: \n"
        + "C2: \n"
        + "C3: \n"
        + "C4: \n"
        + "C5: \n"
        + "C6: \n"
        + "C7: \n"
        + "C8: ", f1.toString());
  }

  // test for renderBoard()
  @Test
  public void correctlyRendersBoardAtStartOfGame() throws IOException {
    s1.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    FreecellView f1 = new FreecellTextView(s1, out);
    f1.renderBoard();
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
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠, A♠", out.toString());
  }

  // test for renderBoard()
  @Test
  public void correctlyRendersBoardAtEndOfGame() throws IOException {
    s1.startGame(l1, 8, 4, false);
    s1.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    s1.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    s1.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    s1.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
    Appendable out = new StringBuilder();
    FreecellView f1 = new FreecellTextView(s1, out);
    f1.renderBoard();
    assertEquals("F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F2: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F3: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: \n"
        + "C2: \n"
        + "C3: \n"
        + "C4: \n"
        + "C5: \n"
        + "C6: \n"
        + "C7: \n"
        + "C8: ", out.toString());
  }

  // test for renderMessage() to see if message is successfully transmitted to data destination
  @Test
  public void correctlyRendersMessageAtStartOfGame() throws IOException {
    s1.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    FreecellView f1 = new FreecellTextView(s1, out);
    f1.renderMessage("Start game.");
    assertEquals("Start game.", out.toString());
  }

  // test for renderMessage() to see if message is successfully transmitted to data destination
  @Test
  public void correctlyRendersMessageAtEndOfGame() throws IOException {
    s1.startGame(l1, 8, 4, false);
    s1.move(PileType.CASCADE, 1, 6, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 3, 6, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 4, PileType.CASCADE, 5);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 5);
    s1.move(PileType.CASCADE, 6, 3, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.CASCADE, 1);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 6, 0, PileType.CASCADE, 1);
    s1.move(PileType.CASCADE, 1, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 1, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 1, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 1, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 1, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 5, PileType.OPEN, 3);
    s1.move(PileType.CASCADE, 4, 4, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 8, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 7, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 5, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 5, 5, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 2, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
    s1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 6);
    s1.move(PileType.CASCADE, 5, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.OPEN, 2);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 5, 3, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 5, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 4, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 3, 2, PileType.CASCADE, 0);
    s1.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 4);
    s1.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 3);
    s1.move(PileType.CASCADE, 2, 5, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 8, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 2, 4, PileType.OPEN, 1);
    s1.move(PileType.CASCADE, 2, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 7, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 7, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 5, 2, PileType.OPEN, 0);
    s1.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 6, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 6, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 5, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 7, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 4, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 3, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 4, 3, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 6, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 4, 2, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 1, 3, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 0, 2, PileType.FOUNDATION, 0);
    s1.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 2, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 3);
    s1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 3);
    s1.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 1);
    s1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    s1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 2);
    s1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
    Appendable out = new StringBuilder();
    FreecellView f1 = new FreecellTextView(s1, out);
    f1.renderMessage("Game over.");
    assertEquals("Game over.", out.toString());
  }

}
