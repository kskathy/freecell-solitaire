import static org.junit.Assert.assertEquals;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.hw02.FreecellCardImpl;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import cs3500.freecell.view.FreecellTextView;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SimpleFreecellController. Tests are made to ensure that the controller and model
 * are working correctly for both a SimpleFreecellModel and a MultiMoveFreecellModel. This test
 * class was originally made for only the SimpleFreecellModel.
 */
public abstract class AbstractControllerTestClass {

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
  public static class SimpleFreecellModelTest extends AbstractControllerTestClass {

    @Override
    public FreecellModel<IFreecellCard> makeModel() {
      return new SimpleFreecellModel();
    }
  }

  /**
   * The test class for the MultiMoveFreecellModel class.
   */
  public static class MultiMoveFreecellModelTest extends AbstractControllerTestClass {

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


  // throws an exception if deck is null
  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionIDeckIsNull() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(null, 8, 4, false);
  }

  // throws an exception if model argument is null
  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionIfModelIsNull() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(null, in, out);
    controller.playGame(l1, 8, 4, false);
  }


  // throws an exception if Readable argument is null
  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionIfReadableIsNull() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    FreecellController controller = new SimpleFreecellController(gameModel, null, out);
    controller.playGame(l1, 8, 4, false);
  }

  // throws an exception if Appendable argument is null
  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionIfAppendableIsNull() {
    gameModel.startGame(l1, 8, 4, false);
    Readable in = new StringReader("C2 7 C6");
    FreecellController controller = new SimpleFreecellController(gameModel, in, null);
    controller.playGame(l1, 8, 4, false);
  }

  // could not start game if there's an invalid number of cascade piles
  @Test
  public void testsInvalidNumberOfCascadePiles() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, -1, 4, false);
    assertEquals("Could not start game.", out.toString());
  }

  // could not start game if there's an invalid number of open piles
  @Test
  public void testsInvalidNumberOfOpenPiles() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 0, false);
    assertEquals("Could not start game.", out.toString());
  }

  // tests quitting the game
  @Test
  public void testsJustQ() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals(true, out.toString().contains("Game quit prematurely."));
  }

  // tests quitting the game but with an upper case Q
  @Test
  public void testsUpperCaseJustQ() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("Q");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals(true, out.toString().contains("Game quit prematurely."));
  }

  // tests an empty string where no valid appendable object was provided.
  @Test(expected = IllegalStateException.class)
  public void testsEmptyString() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
  }

  // throws an exception if Readable runs out of input
  @Test(expected = IllegalStateException.class)
  public void testsRunningOutOfInputs() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 6 C7 C4");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals("", out.toString());
  }

  // throws an exception if Readable runs out of input
  @Test(expected = IllegalStateException.class)
  public void testsRunningOutOfInputs2() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("hi I'm in ood");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals("", out.toString());
  }

  // throws an exception if Readable runs out of input
  @Test(expected = IllegalStateException.class)
  public void testsRunningOutOfInputs3() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 hi");
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    assertEquals("", out.toString());
  }


  // outputs a render message that a move is invalid
  @Test
  public void testsInvalidMove() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 2 C7 q");
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
        + "Invalid move. Try again.\n"
        + "Game quit prematurely.", out.toString());
  }

  // outputs a message that move is invalid because cards cannot be removed from foundation piles
  @Test
  public void testInvalidMoveIfSourcePileIsFoundation() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("F1 3 O2 q");
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
        + "Invalid move. Try again. Source pile cannot be foundation pile.\n"
        + "Game quit prematurely.", out.toString());
  }

  // outputs a render message that a move is invalid because cascade pile is invalid
  @Test
  public void testsInvalidCascadePile() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C-1 2 C7 q");
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
        + "Invalid move. Try again. Invalid cascade pile.\n"
        + "Game quit prematurely.", out.toString());
  }


  // outputs a render message that the source pile is invalid
  @Test
  public void testsInvalidSourcePileInput() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("sdf q");
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
        + "Invalid source pile. Try again.\n"
        + "Game quit prematurely.", out.toString());
  }

  // outputs a render message that the card index is invalid
  @Test
  public void testsInvalidCardIndexInput() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 % Q");
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
        + "Invalid card index. Try again.\n"
        + "Game quit prematurely.", out.toString());
  }

  // outputs a render message that the destination pile is invalid
  @Test
  public void testsInvalidDestinationPileInput() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 6 helloagain Q");
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
        + "Invalid destination pile. Try again.\n"
        + "Game quit prematurely.", out.toString());
  }

  // the controller ignores the invalid inputs until it finds valid inputs and still makes the move
  // while outputting render messages to input valid piles and index.
  @Test
  public void controllerIgnoresInvalidInputs() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("hi C2 it's 7 kathy C6 q");
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
        + "Invalid source pile. Try again.\n"
        + "Invalid card index. Try again.\n"
        + "Invalid destination pile. Try again.\n"
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
        + "Game quit prematurely.", out.toString());
  }

  // the controller ignores the invalid inputs until it finds valid inputs and still makes the move
  // while outputting render messages to input valid piles and index. (With tabs and new lines)
  @Test
  public void controllerIgnoresInvalidInputs2() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("hi C2 it's 7  kathy\nC6 blah C4 blah 7 F2\nC8 6 F4 q");
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
        + "Invalid source pile. Try again.\n"
        + "Invalid card index. Try again.\n"
        + "Invalid destination pile. Try again.\n"
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
        + "Invalid source pile. Try again.\n"
        + "Invalid card index. Try again.\n"
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
        + "Game quit prematurely.", out.toString());
  }

  //  playGame works correctly by starting a new game and completing it successfully
  @Test
  public void testsPlayGameAfterRestart() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 6 O1 "
        + "C7 5 C6 "
        + "O1 1 C6 "
        + "C7 4 O1 "
        + "C7 3 C2 "
        + "O1 1 C2 "
        + "C7 2 F2 "
        + "C7 1 C2 "
        + "C2 9 O1 "
        + "C2 8 O2 "
        + "C2 7 O3 "
        + "C2 6 C7 "
        + "O3 1 C7 "
        + "O2 1 C7 "
        + "O1 1 C7 "
        + "C2 5 F1 "
        + "C5 6 O4 "
        + "C5 5 C7 "
        + "C5 4 F1 "
        + "C6 9 O1 "
        + "C6 8 O2 "
        + "C6 7 O3 "
        + "C6 6 C7 "
        + "O3 1 C7 "
        + "O2 1 C7 "
        + "O1 1 C7 "
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
    gameModel.startGame(l1, 8, 4, false);
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    gameModel.startGame(l1, 8, 4, false);
    FreecellTextView f1 = new FreecellTextView(gameModel);
    assertEquals(true, out.toString().contains("\nGame over.\n"));
  }

  //  playGame works correctly by starting a new game and completing it successfully,
  //  including invalid inputs
  @Test
  public void testsPlayGameAfterRestartWithInvalidInputs() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C-1 2 C7 q");
    gameModel.startGame(l1, 8, 4, false);
    FreecellController controller = new SimpleFreecellController(gameModel, in, out);
    controller.playGame(l1, 8, 4, false);
    gameModel.startGame(l1, 8, 4, false);
    FreecellTextView f1 = new FreecellTextView(gameModel);
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
        + "Invalid move. Try again. Invalid cascade pile.\n"
        + "Game quit prematurely.", out.toString());
  }


  // tests a normal full line of input
  @Test
  public void testsANormalLineOfInput() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 q");
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
        + "Game quit prematurely.", out.toString());
  }

  // tests normal full lines of input
  @Test
  public void testsANormalLineOfInput2() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 6 O1 "
        + "C7 5 C6 Q");
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
        + "O1: 3♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦\n"
        + "C7: 8♠, 2♣, 10♣, 9♥, 4♣\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "F1:\n"
        + "F2: A♣\n"
        + "F3:\n"
        + "F4: A♠\n"
        + "O1: 3♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: Q♠, 10♠, 10♥, 8♣, 7♠, 3♥, 6♦\n"
        + "C2: K♥, K♠, J♣, 9♣, A♥, J♥\n"
        + "C3: J♦, J♠, 5♣, 3♣, K♣, 2♦, Q♥\n"
        + "C4: 8♥, A♦, 4♦, 5♥, 4♥, 5♠\n"
        + "C5: Q♦, 8♦, 9♠, 2♥, 7♦, 9♦\n"
        + "C6: 10♦, 4♠, Q♣, 6♥, 2♠, 6♠, 5♦, 4♣\n"
        + "C7: 8♠, 2♣, 10♣, 9♥\n"
        + "C8: K♦, 7♣, 7♥, 6♣, 3♠\n"
        + "Game quit prematurely.", out.toString());
  }


  // tests that the game over render message successfully is transmitted when the game is over
  @Test
  public void testsGameIsOver() {
    gameModel.startGame(l1, 8, 4, false);
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C2 7 C6 "
        + "C4 7 F2 "
        + "C8 6 F4 "
        + "C7 6 O1 "
        + "C7 5 C6 "
        + "O1 1 C6 "
        + "C7 4 O1 "
        + "C7 3 C2 "
        + "O1 1 C2 "
        + "C7 2 F2 "
        + "C7 1 C2 "
        + "C2 9 O1 "
        + "C2 8 O2 "
        + "C2 7 O3 "
        + "C2 6 C7 "
        + "O3 1 C7 "
        + "O2 1 C7 "
        + "O1 1 C7 "
        + "C2 5 F1 "
        + "C5 6 O4 "
        + "C5 5 C7 "
        + "C5 4 F1 "
        + "C6 9 O1 "
        + "C6 8 O2 "
        + "C6 7 O3 "
        + "C6 6 C7 "
        + "O3 1 C7 "
        + "O2 1 C7 "
        + "O1 1 C7 "
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
