package cs3500.freecell.view;

import cs3500.freecell.model.FreecellModelState;
import java.io.IOException;

/**
 * This class implements FreecellView and represents a textual view of the given FreecellModelState
 * that can be printed to console screen.
 */
public class FreecellTextView implements FreecellView {

  /**
   * Represents the model state of the Freecell game.
   */
  private final FreecellModelState<?> model;

  /**
   * Represents an Appendable destination for data transmission.
   */
  private Appendable ap;

  /**
   * Class constructor that creates a new FreecellTextView from the given model state.
   *
   * @param model An instance of FreecellModelState representing the model state of the Freecell
   *              game state.
   */
  public FreecellTextView(FreecellModelState<?> model) {
    this.model = model;
    this.ap = null;
  }

  /**
   * Class constructor that creates a new FreecellTextView from the given model state and an
   * Appendable object where the model state can be transmitted.
   *
   * @param model An instance of FreecellModelState representing the model state of the Freecell
   *              game state.
   * @param ap    An instance of Appendable where data can be transmitted.
   */
  public FreecellTextView(FreecellModelState<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  /**
   * Return the present state of the game as a string. The string is formatted as follows:
   * <pre>
   * F1:[b]f11,[b]f12,[b],...,[b]f1n1[n] (Cards in foundation pile 1 in order)
   * F2:[b]f21,[b]f22,[b],...,[b]f2n2[n] (Cards in foundation pile 2 in order)
   * ...
   * Fm:[b]fm1,[b]fm2,[b],...,[b]fmnm[n] (Cards in foundation pile m in
   * order)
   * O1:[b]o11[n] (Cards in open pile 1)
   * O2:[b]o21[n] (Cards in open pile 2)
   * ...
   * Ok:[b]ok1[n] (Cards in open pile k)
   * C1:[b]c11,[b]c12,[b]...,[b]c1p1[n] (Cards in cascade pile 1 in order)
   * C2:[b]c21,[b]c22,[b]...,[b]c2p2[n] (Cards in cascade pile 2 in order)
   * ...
   * Cs:[b]cs1,[b]cs2,[b]...,[b]csps (Cards in cascade pile s in order)
   *
   * where [b] is a single blankspace, [n] is newline. Note that there is no
   * newline on the last line
   * </pre>
   *
   * @return the formatted string as above
   */
  @Override
  public String toString() {
    String s = "";
    if (!hasGameStarted(model)) {
      return s;
    }
    for (int pileIndex = 0; pileIndex < 4; pileIndex++) {
      if (model.getNumCardsInFoundationPile(pileIndex) != 0) {
        s += "F" + (pileIndex + 1) + ": ";
        int numCardsInFPile = model.getNumCardsInFoundationPile(pileIndex);
        for (int cardIndex = 0; cardIndex < numCardsInFPile; cardIndex++) {
          if (cardIndex < numCardsInFPile - 1) {
            s += model.getFoundationCardAt(pileIndex, cardIndex).toString() + ", ";
          } else {
            s += model.getFoundationCardAt(pileIndex, cardIndex).toString();
          }
        }
        s += "\n";
      } else {
        s += "F" + (pileIndex + 1) + ":\n";
      }
    }
    int numOpenPiles = model.getNumOpenPiles();
    for (int pileIndex = 0; pileIndex < numOpenPiles; pileIndex++) {
      if (model.getOpenCardAt(pileIndex) != null) {
        s += "O" + (pileIndex + 1) + ": " + model.getOpenCardAt(pileIndex).toString() + "\n";
      } else {
        s += "O" + (pileIndex + 1) + ":\n";
      }
    }
    int numCascadePiles = model.getNumCascadePiles();
    for (int pileIndex = 0; pileIndex < numCascadePiles; pileIndex++) {
      s += "C" + (pileIndex + 1) + ": ";
      int numCardsInCPile = model.getNumCardsInCascadePile(pileIndex);
      for (int cardIndex = 0; cardIndex < numCardsInCPile; cardIndex++) {
        if (cardIndex < numCardsInCPile - 1) {
          s += model.getCascadeCardAt(pileIndex, cardIndex).toString() + ", ";
        } else {
          s += model.getCascadeCardAt(pileIndex, cardIndex).toString();
        }
      }
      if (pileIndex != numCascadePiles - 1) {
        s += "\n";
      }
    }
    return s;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly in the
   * format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    if (ap == null) {
      System.out.println(this.toString());
    } else {
      ap.append(this.toString());
    }
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    if (ap == null) {
      System.out.println(message);
    } else {
      ap.append(message);
    }
  }


  /**
   * Checks whether the game has started or not from the game model state.
   *
   * @param model An instance of FreecellModelState representing the model state of the Freecell
   *              game state.
   * @return true if game has already started, otherwise return false
   */
  private boolean hasGameStarted(FreecellModelState<?> model) {
    for (int i = 0; i < model.getNumOpenPiles(); i++) {
      if (model.getNumOpenPiles() > 0) {
        return true;
      }
    }
    for (int i = 0; i < model.getNumCascadePiles(); i++) {
      if (model.getNumCascadePiles() > 0) {
        return true;
      }
    }
    return false;
  }
}
