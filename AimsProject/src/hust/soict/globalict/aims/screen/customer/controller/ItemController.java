package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.store.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ItemController {

    private Media media;
    private Cart cart = new Cart();



    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;



    // Constructor without Cart parameter
    public ItemController() {
        this.cart = new Cart(); // Initialize a new Cart if not provided
    }

    // Optional: Constructor with Cart parameter for flexibility
    public ItemController(Cart cart) {
        this.cart = cart != null ? cart : new Cart();
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        ensureCartIsInitialized(); // Ensure cart is initialized
        if (media != null) {
            cart.addMedia(media);
            // Tạo cửa sổ thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added to Cart");
            alert.setHeaderText(null); // Không có tiêu đề phụ
            alert.setContentText(media.getTitle() + " has been added to the cart!");

            // Hiển thị thông báo và chờ người dùng đóng
            alert.showAndWait();



            System.out.println("Added to cart: " + media.getTitle());
            System.out.println("Added to cart: " + media.getTitle());
        }

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            System.out.println("Playing: " + media.getTitle());
            ((Playable) media).play();

            // Tạo cửa sổ thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText(null); // Không có tiêu đề phụ
            alert.setContentText("Playing: " + media.getTitle());

            // Hiển thị thông báo và chờ người dùng đóng
            alert.showAndWait();

        }
    }

    // Ensure the cart is initialized
    private void ensureCartIsInitialized() {
        if (cart == null) {
            cart = new Cart(); // Initialize a new Cart if it was null
        }
    }

    // Setter for the cart (optional, to allow setting cart later if needed)
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public Media getMedia() {
        return media;
    }

}
