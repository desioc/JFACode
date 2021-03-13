import javafx.beans.property.*;

public class User {
    private StringProperty name = new SimpleStringProperty("");

    public final StringProperty nameProperty() {
        return name;
    }
    public final void setName(String name) {
        this.name.set(name);
    }
    public final String getName() {
        return name.get();
    }
}