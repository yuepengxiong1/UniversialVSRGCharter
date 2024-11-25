import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;




public class TesterController {

    @FXML
    private Label myLabel;

    private Button btnAddObject;

    @FXML
    private Pane anchorPaneScroll;


    @FXML
    private void handleAddObject() {
        Rectangle square = new Rectangle(50, 50, Color.BLUE);

        // Set an initial position for the rectangle
        square.setTranslateX(100);
        square.setTranslateY(100);

        // Make the rectangle draggable
        makeDraggable(square);

        // Add the rectangle to the content pane
        anchorPaneScroll.getChildren().add(square);
    }

    @FXML
    private void handleAddSquare() {
        // Create a new rectangle
        Rectangle square = new Rectangle(50, 50, Color.BLUE);

        // Set an initial position for the rectangle
        square.setTranslateX(100);
        square.setTranslateY(100);

        // Make the rectangle draggable
        makeDraggable(square);

        // Add the rectangle to the content pane
        anchorPaneScroll.getChildren().add(square);
    }

    @FXML
    private void makeDraggable(Rectangle node) {
        final double[] initialX = new double[1];
        final double[] initialY = new double[1];

        // Mouse pressed: Store initial position
        node.setOnMousePressed((MouseEvent event) -> {
            initialX[0] = event.getSceneX() - node.getTranslateX();
            initialY[0] = event.getSceneY() - node.getTranslateY();
        });

        // Mouse dragged: Update position
        node.setOnMouseDragged((MouseEvent event) -> {
            node.setTranslateX(event.getSceneX() - initialX[0]);
            node.setTranslateY(event.getSceneY() - initialY[0]);
        });
}
}

    

