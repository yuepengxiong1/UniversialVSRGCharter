import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class UniversalCharterApp extends Application {
    
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("UniversalCharterApp.fxml"));
            primaryStage.setTitle("Universal Charter App");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
