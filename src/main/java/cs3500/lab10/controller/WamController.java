package cs3500.lab10.controller;

/**
 * Represents a controller for a game of Whack-a-Mole.
 */
public interface WamController {
  /**
   * Initializes a game of Whack-A-Mole.
   *
   * @throws IllegalStateException if the game board is not defined
   */
  void run() throws IllegalStateException;
}
