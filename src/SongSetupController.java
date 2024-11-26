import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class SongSetupController {

    @FXML
    private TextField txtFArtist;

    @FXML
    private TextField txtFTitle;

    @FXML
    private TextField txtFCreator;

    @FXML
    private TextField txtFDifficultyName;

    @FXML
    private TextField txtFSource;

    @FXML
    private TextField txtFTags;

    @FXML
    private Slider sldrKeyCount;

    @FXML
    private Slider sldrOverallDifficulty;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void initialize() {
        // Initialization code if needed
    }

    @FXML
    private void handleOkButtonAction() {
        // Handle OK button action
        String artist = txtFArtist.getText();
        String title = txtFTitle.getText();
        String creator = txtFCreator.getText();
        String difficultyName = txtFDifficultyName.getText();
        String source = txtFSource.getText();
        String tags = txtFTags.getText();
        double keyCount = sldrKeyCount.getValue();
        double overallDifficulty = sldrOverallDifficulty.getValue();

        // Process the data as needed
    }

    @FXML
    private void handleCancelButtonAction() {
        // Handle Cancel button action
        txtFArtist.clear();
        txtFTitle.clear();
        txtFCreator.clear();
        txtFDifficultyName.clear();
        txtFSource.clear();
        txtFTags.clear();
        sldrKeyCount.setValue(4.0);
        sldrOverallDifficulty.setValue(8.0);
    }
}