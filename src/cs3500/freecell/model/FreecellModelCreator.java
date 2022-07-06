package cs3500.freecell.model;

import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;

/**
 * This class defines a public enum GameType with two possible values SINGLEMOVE and MULTIMOVE.
 */
public class FreecellModelCreator {

  /**
   * Represents the two possible GameTypes.
   */
  public enum GameType {
    SINGLEMOVE, MULTIMOVE
  }

  /**
   * A static factory method that returns either a SimpleFreecellModel or a MultiMoveFreecellModel.
   *
   * @param type either a multi-move or a single move
   * @return either a SimpleFreecellModel or a MultiMoveFreecellModel, depending on the value of the
   *         parameter.
   * @throws IllegalArgumentException if the type is null
   */
  public static FreecellModel<IFreecellCard> create(GameType type) {
    if (type == null) {
      throw new IllegalArgumentException("Invalid GameType");
    }
    if (type == GameType.MULTIMOVE) {
      return new MultiMoveFreecellModel();
    } else {
      return new SimpleFreecellModel();
    }
  }
}
