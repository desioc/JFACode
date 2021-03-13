import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class BoxesTest extends Application {
    private final static double gap = (0.8 * Font.getDefault().getSize());
    public void start(Stage stage) {
        stage.setTitle("Search Engine");
        Button searchButton = new Button("Search");
        Button resetButton = new Button("Reset");
        Label label = new Label("Enter the string to search for");
        TextField text = new TextField();
        final double rem = Font.getDefault().getSize();
        VBox vBox = new VBox(gap);
        HBox northPane = new HBox(gap);
        HBox southPane = new HBox(gap);
        northPane.getChildren().addAll(label, text);
        southPane.getChildren().addAll(searchButton, resetButton);
        southPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(northPane, southPane);
        northPane.setPadding(new Insets(gap));
        southPane.setPadding(new Insets(gap));
        stage.setScene(new Scene(vBox));
        stage.show();
    }
}