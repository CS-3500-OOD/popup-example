package cs3500.lab06.model;

/**
 * Represents a cell on a board.
 */
public class BoardCell {
  private final Coord coord;

  public BoardCell(Coord coord) {
    this.coord = coord;
  }

  /**
   * Gets the cell's coordinates.
   *
   * @return the cell's coordinates
   */
  public Coord getCoords() {
    return this.coord;
  }
}
