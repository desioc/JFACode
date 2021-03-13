import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class BorderPaneTest extends Application {
    public  void start(Stage stage) {
        BorderPane pane= new BorderPane ();
        pane.setTop(new Button("Top"));
        pane.setBottom(new Button("Bottom"));
        pane.setLeft(new Button("Left"));
        pane.setRight(new Button("Right"));
        pane.setCenter(new Button("Center"));
        stage.setScene(new Scene(pane));
        stage.show();
    }
}