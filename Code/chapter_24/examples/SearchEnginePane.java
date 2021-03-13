import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;


public class SearchEnginePane extends VBox {
    private final static double GAP = (0.8 * Font.getDefault().getSize());
    private Button searchButton;
    private Button resetButton ;
    private Label label;
    private TextField text;

    public void setup() {
        HBox northPane = new HBox(GAP);
        HBox southPane = new HBox(GAP);
        northPane.getChildren().addAll(label, text);;
        southPane.getChildren().addAll(searchButton, resetButton);
        southPane.setAlignment(Pos.CENTER);
        getChildren().addAll(northPane, southPane);
        northPane.setPadding(new Insets(GAP));
        southPane.setPadding(new Insets(GAP));
    }

    public SearchEnginePane() {
        super(GAP);
        searchButton = new Button("Search");
        resetButton = new Button("Reset");
        label = new Label("Enter string to search");
        text = new TextField();
        setup();
    }
}