import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TabbedInterfaceExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the TabPane
        TabPane tabPane = new TabPane();

        // General Tab
        Tab generalTab = new Tab("General");
        generalTab.setContent(createGeneralTabContent());
        generalTab.setClosable(false); // Prevent tab from being closed

        // Add other tabs (Difficulty, Audio, etc.)
        Tab difficultyTab = new Tab("Difficulty");
        difficultyTab.setClosable(false);

        Tab audioTab = new Tab("Audio");
        audioTab.setClosable(false);

        Tab coloursTab = new Tab("Colours");
        coloursTab.setClosable(false);

        Tab designTab = new Tab("Design");
        designTab.setClosable(false);

        Tab advancedTab = new Tab("Advanced");
        advancedTab.setClosable(false);

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(generalTab, difficultyTab, audioTab, coloursTab, designTab, advancedTab);

        // Create the main scene
        Scene scene = new Scene(tabPane, 600, 400);

        // Set up the stage
        primaryStage.setTitle("Tabbed Interface Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createGeneralTabContent() {
        VBox content = new VBox(10);

        // Add fields and labels similar to the interface in the image
        Label artistLabel = new Label("Artist:");
        TextField artistField = new TextField("unknown");

        Label romanisedArtistLabel = new Label("Romanised Artist:");
        TextField romanisedArtistField = new TextField("unknown");

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField("unknown");

        Label romanisedTitleLabel = new Label("Romanised Title:");
        TextField romanisedTitleField = new TextField("unknown");

        Label beatmapCreatorLabel = new Label("Beatmap Creator:");
        TextField beatmapCreatorField = new TextField();

        Label difficultyLabel = new Label("Difficulty:");
        ComboBox<String> difficultyComboBox = new ComboBox<>();
        difficultyComboBox.getItems().addAll("9k", "7k", "5k"); // Example options

        Label sourceLabel = new Label("Source:");
        TextField sourceField = new TextField();

        Label tagsLabel = new Label("Tags:");
        TextField tagsField = new TextField();

        Label noteLabel = new Label("A quick note: \nDue to the large number of beatmap submissions, the standard of approval is relatively high. Please ensure your beatmap is at least timed properly, or it will likely be ignored!");

        // Add all the components to the layout
        content.getChildren().addAll(
            artistLabel, artistField,
            romanisedArtistLabel, romanisedArtistField,
            titleLabel, titleField,
            romanisedTitleLabel, romanisedTitleField,
            beatmapCreatorLabel, beatmapCreatorField,
            difficultyLabel, difficultyComboBox,
            sourceLabel, sourceField,
            tagsLabel, tagsField,
            noteLabel
        );

        return content;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
