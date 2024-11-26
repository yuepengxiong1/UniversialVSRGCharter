import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
// Replace with the actual package name

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
        String[] difficultyList = {"Easy", "Medium", "Hard"};
        String[] arrayContainingCharts = {"chart1.osu", "chart2.osu"};

        OSUManiaMetadata osuManiaMetadata = new OSUManiaMetadata(
            "Song Name",
            "Artist Name",
            "Chart Creator",
            "/path/to/chart/directory",
            120.0f,
            500,
            difficultyList,
            arrayContainingCharts
        );

        // Use the osuManiaMetadata object as needed
        System.out.println("Song Name: " + osuManiaMetadata.getSongName());
        System.out.println("Artist: " + osuManiaMetadata.getArtist());
        System.out.println("Creator: " + osuManiaMetadata.getCreatorOfChart());
        System.out.println("Chart Directory: " + osuManiaMetadata.getPathToChartDirectory());
        System.out.println("BPM: " + osuManiaMetadata.BPM);
        System.out.println("Song Offset: " + osuManiaMetadata.setSongOffset);
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