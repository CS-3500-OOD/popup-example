package cs3500.lab10.model;

import java.util.Random;

/**
 * Represents a board of arbitrary dimensions for a game of Whack-A-Mole.
 */
public class Board {
  private final BoardCell[][] board;
  private static final int BOARD_WIDTH = 3;
  private static final int BOARD_HEIGHT = 3;

  /**
   * Instantiates a board for a game of Whack-A-Mole.
   */
  public Board() {
    this.board = new BoardCell[BOARD_HEIGHT][BOARD_WIDTH];
    for (int row = 0; row < BOARD_HEIGHT; row++) {
      for (int col = 0; col < BOARD_WIDTH; col++) {
        Coord coord = new Coord(row, col);
        this.board[row][col] = new BoardCell(coord);
      }
    }
  }

  /**
   * Gets the number of columns on the board.
   *
   * @return the number of columns
   */
  public int getColCount() {
    return BOARD_WIDTH;
  }

  /**
   * Gets the number of rows on the board.
   *
   * @return the number of rows
   */
  public int getRowCount() {
    return BOARD_HEIGHT;
  }

  /**
   * Gets the cell at a specified row and column.
   *
   * @param row the row index
   * @param col the column index
   * @return the cell at the specified location
   * @throws IllegalArgumentException if the given row and/or column are invalid
   */
  public BoardCell getCellAt(int row, int col) throws IllegalArgumentException {
    // validate row
    if (row < 0 || row >= BOARD_HEIGHT) {
      throw new IllegalArgumentException(
          "Invalid row: `" + row + "` is not within [0, " + BOARD_HEIGHT + "].");
    }

    // validate column
    if (col < 0 || col >= BOARD_WIDTH) {
      throw new IllegalArgumentException(
          "Invalid column: `" + col + "` is not within [0, " + BOARD_WIDTH + "].");
    }

    return this.board[row][col];
  }

  /**
   * Gets a random cell on the board.
   *
   * @return a random cell
   */
  public BoardCell getRandomCell() {
    Random rand = new Random();
    return this.board[rand.nextInt(getRowCount())][rand.nextInt(getColCount())];
  }
}
