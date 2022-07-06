import static org.junit.Assert.assertEquals;

import cs3500.freecell.model.FreecellModelCreator;
import cs3500.freecell.model.FreecellModelCreator.GameType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import org.junit.Test;

/**
 * Test class for the FreecellModelCreator class. Tests are made to ensure that the correct model is
 * returned based on the parameter.
 */
public class FreecellModelCreatorTest {

  // a FreecellModelCreator example
  FreecellModelCreator f1 = new FreecellModelCreator();

  // a SimpleFreecellModel example
  SimpleFreecellModel s1 = new SimpleFreecellModel();

  // a MultiMoveFreecellModel example
  MultiMoveFreecellModel m1 = new MultiMoveFreecellModel();

  @Test
  public void correctlyCreatesMultiMoveFreecellModel() {
    assertEquals(true, m1.getClass().equals(f1.create(GameType.MULTIMOVE).getClass()));
  }

  @Test
  public void correctlyCreatesSimpleFreecellModel() {
    assertEquals(true, s1.getClass().equals(f1.create(GameType.SINGLEMOVE).getClass()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disallowsNullType() {
    f1.create(null);
  }

}
