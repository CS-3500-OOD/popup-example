module cs3500.lab09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens cs3500.lab09 to javafx.fxml;
    exports cs3500.lab09;
    exports cs3500.lab09.controller;
    exports cs3500.lab09.model;
    // exports cs3500.lab06.view;
    opens cs3500.lab09.controller to javafx.fxml;
}