public class ModifiableObject {
    private String name;
    private String title;

    public ModifiableObject (String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    public String toString() {
        return name;
    }
}