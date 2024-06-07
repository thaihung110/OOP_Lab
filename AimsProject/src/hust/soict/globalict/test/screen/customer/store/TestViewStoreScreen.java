package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.book.Book;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
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

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);

        launch(args);
    }

}
