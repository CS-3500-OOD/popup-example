package cs3500.lab10.controller;

import cs3500.lab10.model.BoardCell;
import cs3500.lab10.model.BoardModel;
import cs3500.lab10.model.Coord;
import cs3500.lab10.model.Mole;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

/**
 * Represents the controller for a game of Whack-A-Mole.
 */
public class WamControllerImpl implements WamController {
  BoardModel board;
  private Mole mole;
  private int moleWhacks;


  @FXML
  private GridPane buttonGrid;

  private StringProperty[][] buttons;

  private final Random rand = new Random();

  private static final int BUTTON_SIZE = 100;

  /**
   * Initializes a game of Whack-A-Mole.
   *
   * @param board the game board
   * @throws IllegalStateException if the game board is not defined
   */
  @FXML
  public void run(BoardModel board) throws IllegalStateException {
    if (this.board != null) {
      throw new IllegalStateException("Model may only be initialized once.");
    }
    this.board = board;
    this.mole = new Mole(this.board.getRandomCell());
    this.moleWhacks = 0;
    this.buttons = new StringProperty[this.board.getRowCount()][this.board.getColCount()];

    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.75), e -> this.nextTurn());
    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.playFromStart();

    // constraints each column/row to stretch to fill available space
    for (int row = 0; row < this.board.getRowCount(); row++) {
      RowConstraints rowConstraints = new RowConstraints();
      rowConstraints.setVgrow(Priority.ALWAYS);
      buttonGrid.getRowConstraints().add(rowConstraints);

      // iterate through each column
      for (int col = 0; col < this.board.getColCount(); col++) {
        // only initialize columns for first row
        if (row == 0) {
          ColumnConstraints colConstraints = new ColumnConstraints();
          colConstraints.setHgrow(Priority.ALWAYS);
          buttonGrid.getColumnConstraints().add(colConstraints);
        }

        Coord coord = new Coord(row, col);

        // create button
        Button button = new Button();
        button.setPrefWidth(BUTTON_SIZE);
        button.setPrefHeight(BUTTON_SIZE);
        button.setOnAction(e -> handleWhack(coord));

        buttons[row][col] = new SimpleStringProperty("");
        button.textProperty().bind(buttons[row][col]);
        buttonGrid.add(button, col, row);
      }
    }

    this.nextTurn();
  }

  /**
   * Handles a user whacking a cell on the game board.
   *
   * @param coord the coordinates of the cell whacked
   */
  @FXML
  protected void handleWhack(Coord coord) {
    if (mole.getLocation().equals(coord)) {
      this.moleWhacks++;

      // hide the mole
      this.mole.setVisible(false);
      Coord moleLocation = mole.getLocation();
      buttons[moleLocation.getRow()][moleLocation.getCol()].set("");

      System.out.println("Whacked " + this.moleWhacks + " moles!");
    }
  }

  /**
   * Updates the game's view and model to handle moving the mole.
   */
  protected void nextTurn() {
    if (mole.isVisible()) {
      // show mole
      Coord origin = mole.getLastKnownLocation();
      buttons[origin.getRow()][origin.getCol()].set("");

      Coord dest = mole.getLocation();
      buttons[dest.getRow()][dest.getCol()].set(">MOLE<");

      // hide mole for next turn
      mole.setVisible(false);
    } else {
      // determine destination
      int destRow = rand.nextInt(this.board.getRowCount());
      int destCol = rand.nextInt(this.board.getColCount());
      BoardCell destCell = this.board.getCellAt(destRow, destCol);

      // update mole
      mole.move(destCell);
      mole.setVisible(true);
    }
  }
}