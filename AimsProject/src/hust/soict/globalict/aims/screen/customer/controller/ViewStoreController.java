package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Clock;

public class ViewStoreController {

    private Cart cart = new Cart();
    private Store store =  new Store();

    public ViewStoreController(Store store) {
        this.store = store;
        // initialize();
    }

    public ViewStoreController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
        // initialize();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private GridPane gridPane = new GridPane();

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart)); // Đảm bảo controller được thiết lập chính xác
            Parent root = fxmlLoader.load(); // Tải file FXML
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize()
    {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            System.out.println(store.getItemsInStore().get(i));
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ITEM_FXML_FILE_PATH));
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();

                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
                gridPane.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
