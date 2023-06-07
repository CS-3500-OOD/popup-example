package cs3500.lab10.view;

import cs3500.lab10.controller.WamController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a simple Whack-a-Mole GUI view.
 */
public class WamGuiViewImpl<T> implements WamGuiView<T> {
  private final FXMLLoader loader;

  /**
   * Loads an instance of a simple Whack-a-Mole GUI layout from disk.
   */
  public WamGuiViewImpl(WamController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("board.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads the scene from the simple Whack-a-Mole GUI layout.
   *
   * @return the layout
   */
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  /**
   * Returns the controller associated with the simple
   * Whack-a-Mole GUI view's root object.
   *
   * @return the controller
   */
  public T getController() {
    return this.loader.getController();
  }
}
