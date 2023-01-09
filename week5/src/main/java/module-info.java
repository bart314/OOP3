module nl.hanze.modelviewcontroller {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.hanze.modelviewcontroller to javafx.fxml;
    exports nl.hanze.modelviewcontroller;
}