import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

public class SearchEngineStart extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Search Engine");
       // SearchEnginePane pane = new SearchEnginePane();
       //SearchEngineContainer pane = new SearchEngineContainer();
       // SearchEngineGridPane pane = new SearchEngineGridPane();
       SearchEngineGridPaneCSS pane = new SearchEngineGridPaneCSS();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("test.css");
        stage.setScene(scene);
        stage.show();
    }
}