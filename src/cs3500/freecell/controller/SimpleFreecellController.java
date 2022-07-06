package cs3500.freecell.controller;

import cs3500.freecell.model.FreecellModel;
import cs3500.freecell.model.PileType;
import cs3500.freecell.model.hw02.SimpleFreecellModel;
import cs3500.freecell.model.hw02.IFreecellCard;
import cs3500.freecell.view.FreecellTextView;
import cs3500.freecell.view.FreecellView;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * This is the SimpleFreecellController class that accepts the model and the objects.
 */
public class SimpleFreecellController implements FreecellController<IFreecellCard> {

  /**
   * Represents the model state of the Freecell game.
   */
  private FreecellModel<IFreecellCard> model;

  /**
   * Represents the view for transmitting the game state and other user-specific messages.
   */
  private FreecellView view;

  /**
   * Represents the input source from where the game moves will be read.
   */
  private Readable rd;

  /**
   * Represents the output destination for data transmission.
   */
  private Appendable ap;

  /**
   * Create a new instance of SimpleFreecellController from the given parameters.
   *
   * @param model the model state of the Freecell game.
   * @param rd    An instance of Readable
   * @param ap    An instance of Appendable
   * @throws IllegalArgumentException if either of the arguments are null
   */
  public SimpleFreecellController(FreecellModel<IFreecellCard> model, Readable rd, Appendable ap)
      throws IllegalArgumentException {
    if (rd == null || ap == null || model == null) {
      throw new IllegalArgumentException("arguments cannot be null");
    }
    this.model = model;
    this.rd = rd;
    this.ap = ap;
    view = new FreecellTextView(model, ap);
  }

  /**
   * Start and play a new game of freecell with the provided deck. This deck should be used as-is.
   * This method returns only when the game is over (either by winning or by quitting).
   *
   * @param deck        the deck to be used to play this game
   * @param numCascades the number of cascade piles
   * @param numOpens    the number of open piles
   * @param shuffle     shuffle the deck if true, false otherwise
   * @throws IllegalStateException    if writing to the Appendable object used by it fails or
   *                                  reading from the provided Readable fails
   * @throws IllegalArgumentException if the model or deck provided to it are null
   */
  @Override
  public void playGame(List<IFreecellCard> deck, int numCascades, int numOpens, boolean shuffle)
      throws IllegalStateException, IllegalArgumentException {
    Scanner scan = new Scanner(this.rd);
    // Check for illegal arguments
    if (model == null) {
      throw new IllegalArgumentException("model is null");
    }
    if (deck == null) {
      throw new IllegalArgumentException("deck is null");
    }

    try {
      // start the game
      model.startGame(deck, numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException ex) {
      // handle illegal arguments for startGame
      try {
        view.renderMessage("Could not start game.");
        return;
      } catch (IOException e) {
        // handle IO exception while data transmission
        throw new IllegalStateException(e);
      }
    }
    try {
      String token;
      PileType source;
      Integer pileNumber;
      Integer cardIndex;
      PileType destination;
      Integer destPileNumber;

      // render the board with a newline to output transmission
      view.renderBoard();
      ap.append("\n");

      if (!scan.hasNext()) {
        throw new IllegalStateException("ran out of inputs.");
      }
      // loop to process three consecutive inputs for a move
      while (!model.isGameOver() && scan.hasNext()) {
        token = scan.next();
        if (token.equalsIgnoreCase("q")) {
          view.renderMessage("Game quit prematurely.");
          return;
        } else {
          // loop to parse first move input unless a correct one is found
          while (true) {
            // quit the game if 'q' or 'Q' encountered
            if (token.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely.");
              return;
            }
            if (!scan.hasNext()) {
              throw new IllegalStateException("ran out of inputs.");
            }
            // handle when given an invalid input
            if (parsePileType(token) == null) {
              token = scan.next();
              view.renderMessage("Invalid source pile. Try again.\n");
              continue;
            }
            // ----- parse the first input (source pile) for move
            source = parsePileType(token);
            if (source == null || token.length() < 2) {
              continue;
            }
            pileNumber = parseIndex(token.substring(1));
            if (pileNumber == null) {
              continue;
            }
            pileNumber--;
            token = scan.next();
            break;
          }

          // loop to parse second move input unless a correct one is found
          while (true) {
            // quit the game if 'q' or 'Q' encountered
            if (token.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely.");
              return;
            }
            if (!scan.hasNext()) {
              throw new IllegalStateException("ran out of inputs.");
            }
            // handle when given an invalid input
            if (parseIndex(token) == null) {
              token = scan.next();
              view.renderMessage("Invalid card index. Try again.\n");
              continue;
            }
            // ----- parse the second input (card index) for move
            cardIndex = parseIndex(token);
            if (cardIndex == null) {
              continue;
            }
            cardIndex--;
            token = scan.next();
            break;
          }

          // loop to parse third move input unless a correct one is found
          while (true) {
            // quit the game if 'q' or 'Q' encountered
            if (token.equalsIgnoreCase("q")) {
              view.renderMessage("Game quit prematurely.");
              return;
            }
            // handle when given an invalid input
            if (parsePileType(token) == null) {
              token = scan.next();
              view.renderMessage("Invalid destination pile. Try again.\n");
              continue;
            }
            // ----- parse the third input (destination pile) for move
            destination = parsePileType(token);
            if (destination == null || token.length() < 2) {
              continue;
            }
            destPileNumber = parseIndex(token.substring(1));
            if (destPileNumber == null) {
              continue;
            }
            destPileNumber--;
            break;
          }

          // make the move
          try {
            model.move(source, pileNumber, cardIndex, destination, destPileNumber);
            // transmit current game state to the output
            view.renderBoard();
            ap.append("\n");
          } catch (IllegalArgumentException ex) {
            if (source == PileType.FOUNDATION) {
              view.renderMessage(
                  "Invalid move. Try again. Source pile cannot be foundation pile.\n");
              continue;
            }
            if ((source == PileType.CASCADE || destination == PileType.CASCADE)
                && (pileNumber < 0 || pileNumber > 8)) {
              view.renderMessage("Invalid move. Try again. Invalid cascade pile.\n");
              continue;
            }
            if ((source == PileType.OPEN || destination == PileType.OPEN)
                && (pileNumber < 0 || pileNumber > 4)) {
              view.renderMessage("Invalid move. Try again. Invalid open pile.\n");
              continue;
            }
            if (cardIndex < 0 || cardIndex > 14) {
              view.renderMessage("Invalid move. Try again. Invalid open pile.\n");
              continue;
            } else {
              view.renderMessage("Invalid move. Try again.\n");
            }
          }
        }
      }
      // transmit game over to the output
      view.renderBoard();
      view.renderMessage("\nGame over.\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Parses a string to extract PileType.
   *
   * @param s a string
   * @return A PileType if s is in correct format, else return null
   */
  private PileType parsePileType(String s) {
    char firstChar = s.charAt(0);
    if (firstChar == 'O') {
      return PileType.OPEN;
    }
    if (firstChar == 'C') {
      return PileType.CASCADE;
    }
    if (firstChar == 'F') {
      return PileType.FOUNDATION;
    }
    return null;
  }

  /**
   * Parses a string to extract an index integer.
   *
   * @param s a string
   * @return parsed integer if successful, else return null
   */
  private Integer parseIndex(String s) {
    try {
      int number = Integer.parseInt(s);
      return number;
    } catch (NumberFormatException e) {
      return null;
    }
  }

  /**
   * Executes the program.
   *
   * @param args the arguments passed into the program
   */
  public static void main(String[] args) {
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    FreecellModel<IFreecellCard> model = new SimpleFreecellModel();
    FreecellController<IFreecellCard> freecellController = new SimpleFreecellController(model, rd,
        ap);
    freecellController.playGame(null, 8, 3, false);
  }

}
