package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private ToggleGroup toolToggleGroup;

    private Color drawingColor = Color.BLACK;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Tạo một danh sách tạm thời chứa tất cả các hình vẽ
        List<Node> toRemove = new ArrayList<>();
        for (Node node : drawingAreaPane.getChildren()) {
            if (node instanceof Circle) {
                toRemove.add(node);
            }
        }
        // Xóa tất cả các hình vẽ khỏi drawingAreaPane
        drawingAreaPane.getChildren().removeAll(toRemove);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Kiểm tra xem sự kiện diễn ra trên drawingAreaPane
        if (event.getTarget() == drawingAreaPane) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawingColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void handleToolChange(ActionEvent event) {
        if (penRadioButton.isSelected()) {
            drawingColor = Color.BLACK;
        } else if (eraserRadioButton.isSelected()) {
            drawingColor = Color.WHITE;
        }
    }

}
