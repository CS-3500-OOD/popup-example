module cs3500.lab06 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens cs3500.lab06 to javafx.fxml;
    exports cs3500.lab06;
    exports cs3500.lab06.controller;
    exports cs3500.lab06.model;
    // exports cs3500.lab06.view;
    opens cs3500.lab06.controller to javafx.fxml;
}