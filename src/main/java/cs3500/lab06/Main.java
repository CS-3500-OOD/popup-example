package cs3500.lab06;

import cs3500.lab06.controller.WamController;
import cs3500.lab06.model.BoardModel;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Represents a Whack-A-Mole game application.
 */
public class Main extends Application {
  /**
   * Starts the GUI for a game of Whack-A-Mole.
   *
   * @param stage the JavaFX stage to add elements to
   * @throws IOException if the board layout cannot be loaded
   */
  @Override
  public void start(Stage stage) throws IOException {
    BorderPane root = new BorderPane();
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getClassLoader().getResource("board.fxml"));
    root.setCenter(fxmlLoader.load());
    WamController wamController = fxmlLoader.getController();

    BoardModel model = new BoardModel();
    wamController.initialize(model);

    Scene scene = new Scene(root, 500, 425);
    stage.setTitle("Whack-a-Mole!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}