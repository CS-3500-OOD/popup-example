package cs3500.lab10.view;

import javafx.scene.Scene;

/**
 * Represents a GUI view for a game of Whack-a-Mole.
 */
public interface WamGuiView {
  /**
   * Loads a scene from a Whack-a-Mole GUI layout.
   *
   * @return the layout
   */
  Scene load() throws IllegalStateException;
}
