module AimsProject {
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.controls;

    // Open the package to javafx.fxml
    opens hust.soict.globalict.aims.screen.customer.controller to javafx.fxml;

    exports hust.soict.globalict.aims.screen.customer.controller;
    exports hust.soict.globalict.aims.store;
    exports hust.soict.globalict.test.screen.customer.store;
    exports hust.soict.globalict.test.screen.customer.cart;
}