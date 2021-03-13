package phonebook.data;
import phonebook.util.Counter;

public abstract class Entity implements Data, Identifiable {
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
    @Override
    public String toString() {
        return "Id="+getId();
    }
}