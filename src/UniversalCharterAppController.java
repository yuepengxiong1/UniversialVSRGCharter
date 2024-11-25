import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class UniversalCharterAppController {

    @FXML
    private Button btnCreateNew;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblTitle;

    @FXML
    private ImageView imgLogo;

    @FXML
    protected void handleCreateNewChartOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tester.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Create New Chart");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleOpenOnAction(ActionEvent event) {
        lblTitle.setText("Opening Chart...");
    }

    @FXML
    protected void handleExitOnAction(ActionEvent event) {
        lblTitle.setText("Exiting...");
    }
}
