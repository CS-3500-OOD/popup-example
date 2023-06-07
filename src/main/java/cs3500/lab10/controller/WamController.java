package cs3500.lab10.controller;

import cs3500.lab10.model.BoardModel;

public interface WamController {
  /**
   * Initializes a game of Whack-A-Mole.
   *
   * @param board the game board
   * @throws IllegalStateException if the game board is not defined
   */
  void run(BoardModel board) throws IllegalStateException;
}
