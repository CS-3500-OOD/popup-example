package cs3500.lab10.model;

/**
 * Represents a mole in a game of Whack-A-Mole.
 */
public class Mole {
  private BoardCell location;
  private BoardCell lastKnownLocation;
  private boolean isVisible;

  /**
   * Instantiates a visible mole on an initial cell of a game board.
   *
   * @param initLocation the mole's initial location
   */
  public Mole(BoardCell initLocation) {
    this.location = initLocation;
    this.lastKnownLocation = initLocation;
    this.isVisible = false;
  }

  /**
   * Gets the current location of the mole.
   *
   * @return the mole's coordinates
   */
  public Coord getLocation() {
    return location.getCoords();
  }

  /**
   * Gets the last known location of the mole.
   *
   * @return the mole's last known coordinates
   */
  public Coord getLastKnownLocation() {
    return lastKnownLocation.getCoords();
  }

  /**
   * Moves the mole the specified location.
   *
   * @param newLocation the destination cell
   */
  public void move(BoardCell newLocation) {
    lastKnownLocation = this.location;
    location = newLocation;
  }

  /**
   * Determines if the mole is visible.
   *
   * @return if the mole is visible
   */
  public boolean isVisible() {
    return this.isVisible;
  }

  /**
   * Sets if the mole is visible.
   *
   * @param visible if the mole is visible
   */
  public void setVisible(boolean visible) {
    this.isVisible = visible;
  }
}
