package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.store.Media;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    private Cart cart = new Cart();
    private Store store = new Store();
    private Media media;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartController() {
        // Không cần thực hiện thêm bất kỳ thao tác nào trong constructor này
    }

    public CartController(Cart cart) {
        this.cart = cart;
        // initialize();
    }

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
        // initialize();
    }

    public void initialize() {
        // Kiểm tra và khởi tạo các cột TableColumn
        if (colMediaId != null) {
            colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        } else {
            System.out.println("colMediaId is null");
        }

        if (colMediaTitle != null) {
            colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        } else {
            System.out.println("colTitle is null");
        }

        if (colMediaCategory != null) {
            colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        } else {
            System.out.println("colCategory is null");
        }

        if (colMediaCost != null) {
            colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        } else {
            System.out.println("colCost is null");
        }

        // Đổ dữ liệu vào TableView nếu nó đã được khởi tạo
        if (tblMedia != null) {
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        } else {
            System.out.println("tblMedia is null");
        }

        // Kiểm tra các nút để đảm bảo chúng không bị null
        if (btnPlay != null) {
            // Thiết lập nút Play nếu cần
            btnPlay.setVisible(true);
        } else {
            System.out.println("btnPlay is null");
        }

        if (btnRemove != null) {
            // Thiết lập nút Remove nếu cần
            btnRemove.setVisible(true);
        } else {
            System.out.println("btnRemove is null");
        }


        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        // Cập nhật Label tổng chi phí khi khởi tạo
        updateTotalCostLabel();

    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnPlay.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy đối tượng Media được chọn từ TableView
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        // Kiểm tra xem đối tượng đó có phải là Playable không
        if (selectedMedia != null && selectedMedia instanceof Playable) {
            Playable playableMedia = (Playable) selectedMedia;
            playableMedia.play(); // Thực hiện hành động play

            // Tạo và hiển thị cửa sổ thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText(null); // Không có tiêu đề phụ
            alert.setContentText("Playing: " + selectedMedia.getTitle());

            // Hiển thị thông báo và chờ người dùng đóng
            alert.showAndWait();

            System.out.println("Playing: " + selectedMedia.getTitle());
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Lấy đối tượng Media được chọn từ TableView
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        // Kiểm tra nếu một mục được chọn
        if (selectedMedia != null) {
            // Xóa Media khỏi Cart
            cart.removeMedia(selectedMedia);

            // Cập nhật lại TableView
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));

            // Cập nhật Label tổng chi phí
            updateTotalCostLabel();

            // Tạo và hiển thị cửa sổ thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Media Removed");
            alert.setHeaderText(null); // Không có tiêu đề phụ
            alert.setContentText("Removed: " + selectedMedia.getTitle());

            // Hiển thị thông báo và chờ người dùng đóng
            alert.showAndWait();

            System.out.println("Removed from cart: " + selectedMedia.getTitle());
        } else {
            // Nếu không có Media nào được chọn để xóa
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null); // Không có tiêu đề phụ
            alert.setContentText("No media selected for removal.");

            // Hiển thị thông báo và chờ người dùng đóng
            alert.showAndWait();

            System.out.println("No media selected for removal.");
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            // Nếu giỏ hàng trống, hiển thị cảnh báo
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty. Please add items before placing an order.");

            alert.showAndWait();
            return;
        }

        // Giả định rằng bạn thực hiện đặt hàng ở đây (có thể thêm logic liên quan nếu cần)

        // Hiển thị thông báo thành công
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");

        // Hiển thị thông báo và chờ người dùng đóng
        alert.showAndWait();

        // Xóa giỏ hàng sau khi đặt hàng thành công
        cart.emptyCart();

        // Cập nhật lại TableView và Label tổng chi phí
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        updateTotalCostLabel();
    }

    private void updateTotalCostLabel() {
        float totalCost = cart.totalCost(); // Giả định rằng phương thức totalCost() của Cart trả về tổng chi phí của tất cả các mục trong giỏ hàng
        costLabel.setText(String.format("%.2f $", totalCost));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart)); // Đảm bảo controller được thiết lập chính xác
            Parent root = fxmlLoader.load(); // Tải file FXML
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
