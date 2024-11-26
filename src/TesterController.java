import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
    private void handleMenuNewChart(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SongSetup.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Song Setup");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        private void handleCreateBPMLines() {
        double bpm = 140;
        double seconds = 10;
        double interval = 60.0 / bpm; // interval between lines in seconds
        double totalLines = seconds / interval;

        for (int i = 0; i < totalLines; i++) {
            double positionY = i * 50; // separate lines by 50px
            double timeOfMeasureLine = i * interval; // calculate the time of the measure line

            Rectangle line = new Rectangle(anchorPaneScroll.getWidth(), 2, Color.RED);
            line.setTranslateY(positionY);

            anchorPaneScroll.getChildren().add(line);

            // Extend the scroll pane if the line is moved outside its current bounds
            if (positionY + line.getHeight() > anchorPaneScroll.getHeight()) {
            anchorPaneScroll.setPrefHeight(positionY + line.getHeight());
            }

            // Print the time of the measure line
            System.out.println("Measure line at Y: " + positionY + " corresponds to time: " + timeOfMeasureLine + " seconds");
        }

        // Create 4 columns
        for (int i = 0; i < 4; i++) {
            double positionX = i * (anchorPaneScroll.getWidth() / 4); // separate columns evenly

            Rectangle column = new Rectangle(2, anchorPaneScroll.getHeight(), Color.RED);
            column.setTranslateX(positionX);

            anchorPaneScroll.getChildren().add(column);
        }
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
            double newTranslateX = event.getSceneX() - initialX[0];
            double newTranslateY = event.getSceneY() - initialY[0];

            // Update the position of the node
            node.setTranslateX(newTranslateX);
            node.setTranslateY(newTranslateY);

            // Snap to the closest measure line
            double closestLineY = Math.round(newTranslateY / 50) * 50;
            node.setTranslateY(closestLineY);
        });
        
        
}
}

    

