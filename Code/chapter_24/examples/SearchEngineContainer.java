import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane; 

public class SearchEngineContainer extends BorderPane {
    private Label labelTop;
    private Label labelBottom;
    public SearchEngineContainer() {
        super();
        labelTop = new Label("Page header");
        labelBottom = new Label("Search Results");
        setup();
    }
    public void setup() {
        this.setTop(labelTop);
        this.setBottom(labelBottom);
        BorderPane.setAlignment(labelTop, Pos.CENTER);
        BorderPane.setAlignment(labelBottom, Pos.CENTER);
        this.setCenter(new SearchEnginePane());
    }
}    