package cs3500.lab10.model;

/**
 * Represents a board in a game of Whack-A-Mole
 */
public interface WamBoard {
  /**
   * Gets the number of columns on the board.
   *
   * @return the number of columns
   */
  int getColCount();

  /**
   * Gets the number of rows on the board.
   *
   * @return the number of rows
   */
  int getRowCount();

  /**
   * Gets the cell at a specified row and column.
   *
   * @param row the row index
   * @param col the column index
   * @return the cell at the specified location
   */
  BoardCell getCellAt(int row, int col);

  /**
   * Gets a random cell on the board.
   *
   * @return a random cell
   */
  BoardCell getRandomCell();
}
