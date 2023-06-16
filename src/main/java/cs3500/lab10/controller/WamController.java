package cs3500.lab10.controller;

import java.io.IOException;

/**
 * Represents a controller for a game of Whack-a-Mole.
 */
public interface WamController {
  /**
   * Initializes a game of Whack-A-Mole.
   *
   * @throws IllegalStateException if the game board is not defined
   */
  void run() throws IllegalStateException, IOException;
}
