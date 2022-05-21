module SOCR.project.main {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports GUI;
    opens GUI to javafx.fxml;
}