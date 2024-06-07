package hust.soict.globalict.test.screen.customer.cart;
import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.store.Media;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCartScreen extends Application{

    // Tạo đối tượng giỏ hàng
    private static Cart cart = new Cart();
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load file FXML của CartController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Cart.fxml"));
        Parent root = loader.load();

        // Lấy controller của CartController
        CartController controller = loader.getController();

        // Gán giỏ hàng cho controller
        controller.setCart(cart);

        // Khởi tạo controller
        controller.initialize();

        // Tạo scene và hiển thị cửa sổ
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cart Controller Test");
        primaryStage.show();
    }

    public static void main(String[] args) {

        List<String> authors1 = Arrays.asList("Author A", "Author B");
        List<String> authors2 = Arrays.asList("Author C");

        Book book1 = new Book(1, "Java Programming", "Education", 59.99f, authors1);
        Book book2 = new Book(2, "Advanced Algorithms", "Education", 79.99f, authors2);

        // Creating instances of DigitalVideoDisc
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "The Matrix", "Sci-Fi", "The Wachowskis",
                136, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(4, "Inception", "Sci-Fi", "Christopher Nolan",
                148, 24.99f);

        // Creating instances of Track
        Track track1 = new Track("Track A", 5);
        Track track2 = new Track("Track B", 3);
        Track track3 = new Track("Track C", 4);

        // Creating a list of tracks for CompactDisc
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);

        // Creating instances of CompactDisc
        CompactDisc cd1 = new CompactDisc(5, "Greatest Hits", "Music", "Thai Hung Vu",
                29.99f, "Various Artists", tracks);
        CompactDisc cd2 = new CompactDisc(6, "Classical Collection", "Music", "Thai Hung Vu",
                39.99f, "Various Artists", tracks);

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(book1);

        launch(args);
    }
}
