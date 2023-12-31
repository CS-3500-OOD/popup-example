package cs3500.lab10;

import cs3500.lab10.controller.WamController;
import cs3500.lab10.controller.WamControllerImpl;
import cs3500.lab10.model.BoardImpl;
import cs3500.lab10.model.WamBoard;
import cs3500.lab10.view.WamGuiView;
import cs3500.lab10.view.WamGuiViewImpl;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents a Whack-A-Mole game application.
 */
public class Driver extends Application {
  /**
   * Starts the GUI for a game of Whack-A-Mole.
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    // add a title to the stage
    stage.setTitle("The OOD Whack-a-Mole Arcade");

    // instantiate the board model and WAM controller
    WamBoard board = new BoardImpl();
    WamController wamController = new WamControllerImpl(board, stage);

    // instantiate a simple Whack-a-Mole GUI view
    WamGuiView wgv = new WamGuiViewImpl(wamController);

    try {
      // load and place the view's scene onto the stage
      stage.setScene(wgv.load());

      // fetch the view's controller
      wamController.run();

      // render the stage
      stage.show();
    } catch (IllegalStateException | IOException e) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Entry point for a game of Whack-a-Mole.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}