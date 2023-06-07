module cs3500.lab10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens cs3500.lab10 to javafx.fxml;
    exports cs3500.lab10;
    exports cs3500.lab10.controller;
    exports cs3500.lab10.model;
    exports cs3500.lab10.view;
    opens cs3500.lab10.controller to javafx.fxml;
}