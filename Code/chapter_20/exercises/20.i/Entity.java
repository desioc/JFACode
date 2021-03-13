package phonebook.data;
import phonebook.util.Counter;
import java.io.Serializable;

public abstract class Entity implements Data, Identifiable, Serializable {
    private int id;

    public Entity () {
        setId(Counter.getSerialNumber());
    }
    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}