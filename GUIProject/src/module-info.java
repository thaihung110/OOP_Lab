module GUIProject {
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.controls;

    // Open the package to javafx.fxml
    opens hust.soict.globalict.javafx to javafx.fxml;

    exports hust.soict.globalict.javafx;
}