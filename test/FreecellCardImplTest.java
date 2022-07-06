import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.hw02.FreecellCardImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for FreecellCardImpl. Tests are made to ensure that each card in a deck is valid, and
 * all cards are functioning correctly in relation to other cards.
 */
public class FreecellCardImplTest {

  // tests the constructor
  @Test(expected = IllegalArgumentException.class)
  public void testSuiteAsNullCase() {
    FreecellCardImpl nullCaseSuite = new FreecellCardImpl(null, 12);
  }

  // tests the constructor
  @Test(expected = IllegalArgumentException.class)
  public void testValueAsZero() {
    FreecellCardImpl zeroAsValue = new FreecellCardImpl("Diamonds", 0);
  }

  // tests the constructor
  @Test(expected = IllegalArgumentException.class)
  public void testSuiteAndValueAsNullAndZero() {
    FreecellCardImpl nullCaseSuiteZeroAsValue = new FreecellCardImpl(null, 0);
  }

  // tests getValue()
  @Test
  public void correctlyGetsValue() {
    FreecellCardImpl aceOfHearts = new FreecellCardImpl("Hearts", 1);
    FreecellCardImpl twoOfClubs = new FreecellCardImpl("Clubs", 2);
    FreecellCardImpl jackOfDiamonds = new FreecellCardImpl("Diamonds", 11);
    FreecellCardImpl kingOfSpades = new FreecellCardImpl("Spades", 13);
    assertEquals(1, aceOfHearts.getValue());
    assertEquals(2, twoOfClubs.getValue());
    assertEquals(11, jackOfDiamonds.getValue());
    assertEquals(13, kingOfSpades.getValue());
  }

  // tests getSuite()
  @Test
  public void correctlyGetsSuite() {
    FreecellCardImpl threeOfHearts = new FreecellCardImpl("Hearts", 3);
    FreecellCardImpl fiveOfClubs = new FreecellCardImpl("Clubs", 5);
    FreecellCardImpl jackOfDiamonds = new FreecellCardImpl("Diamonds", 11);
    FreecellCardImpl queenOfSpades = new FreecellCardImpl("Spades", 12);
    assertEquals("Hearts", threeOfHearts.getSuite());
    assertEquals("Clubs", fiveOfClubs.getSuite());
    assertEquals("Diamonds", jackOfDiamonds.getSuite());
    assertEquals("Spades", queenOfSpades.getSuite());
  }

  // tests toString()
  @Test
  public void correctlyGetsStringAndSymbolRepresentation() {
    FreecellCardImpl aceOfHearts = new FreecellCardImpl("Hearts", 1);
    FreecellCardImpl twoOfClubs = new FreecellCardImpl("Clubs", 2);
    FreecellCardImpl jackOfDiamonds = new FreecellCardImpl("Diamonds", 11);
    FreecellCardImpl kingOfSpades = new FreecellCardImpl("Spades", 13);
    assertEquals("A♥", aceOfHearts.toString());
    assertEquals("2♣", twoOfClubs.toString());
    assertEquals("J♦", jackOfDiamonds.toString());
    assertEquals("K♠", kingOfSpades.toString());
  }

  // tests getColor()
  @Test
  public void correctlyGetsColor() {
    FreecellCardImpl threeOfHearts = new FreecellCardImpl("Hearts", 3);
    FreecellCardImpl fiveOfClubs = new FreecellCardImpl("Clubs", 5);
    FreecellCardImpl jackOfDiamonds = new FreecellCardImpl("Diamonds", 11);
    FreecellCardImpl queenOfSpades = new FreecellCardImpl("Spades", 12);
    assertEquals("Red", threeOfHearts.getColor());
    assertEquals("Black", fiveOfClubs.getColor());
    assertEquals("Red", jackOfDiamonds.getColor());
    assertEquals("Black", queenOfSpades.getColor());
  }

  // tests equals()
  @Test
  public void correctlyReturnsEqual() {
    FreecellCardImpl aceOfHearts = new FreecellCardImpl("Hearts", 1);
    FreecellCardImpl aceOfDiamonds = new FreecellCardImpl("Diamonds", 1);
    FreecellCardImpl aceOfHearts2 = new FreecellCardImpl("Hearts", 1);
    Assert.assertTrue(aceOfHearts.equals(aceOfHearts2));
    Assert.assertFalse(aceOfHearts.equals(aceOfDiamonds));
    Assert.assertFalse(aceOfDiamonds.equals(aceOfHearts2));
    Assert.assertTrue(aceOfHearts.equals(aceOfHearts));
  }

  // tests hashCode()
  @Test
  public void correctlyReturnsHashCodeIntValue() {
    FreecellCardImpl aceOfHearts = new FreecellCardImpl("Hearts", 1);
    FreecellCardImpl twoOfClubs = new FreecellCardImpl("Clubs", 2);
    FreecellCardImpl jackOfDiamonds = new FreecellCardImpl("Diamonds", 11);
    FreecellCardImpl kingOfSpades = new FreecellCardImpl("Spades", 13);
    assertEquals(-1834573739, aceOfHearts.hashCode());
    assertEquals(2021477638, twoOfClubs.hashCode());
    assertEquals(-921350675, jackOfDiamonds.hashCode());
    assertEquals(-347478656, kingOfSpades.hashCode());
  }
}
