import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;


public class SearchEngineGridPaneCSS extends GridPane {
    private final static double GAP = (0.8 * Font.getDefault().getSize());
    private Button searchButton;
    private Button resetButton ;
    private Label label;
    private TextField text;
    private Label labelBottom;
    public void setup() {
        this.getStyleClass().add("label");
        //this.setId("back");
        this.add(label,0,0);
        this.add(text,1,0); 
        this.add(searchButton,0,1);
        this.add(resetButton,1,1);
        this.add(labelBottom,0,2, 2,10);
        this.setStyle("-fx-background-image: url(\"rock.jpg\")");
        GridPane.setHalignment(labelBottom, HPos.CENTER);
        GridPane.setHalignment(searchButton, HPos.RIGHT);
        GridPane.setHalignment(resetButton, HPos.LEFT);
        this.setHgap(GAP);
        this.setVgap(GAP);
        this.setPadding(new Insets(GAP));
        //this.setGridLinesVisible(true);
    }
    
    public void registerListeners(){
        resetButton.setOnAction(event -> text.setText("") );
    }

    public SearchEngineGridPaneCSS() {
        super();
        searchButton = new Button("Search");
        resetButton = new Button("Reset");
        label = new Label("Enter the string to search for");
        text = new TextField();
        labelBottom = new Label("Search Results");
        setup();
        registerListeners();
    }
}