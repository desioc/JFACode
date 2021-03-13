public class Character {
    private String type;
    private int size;

    public Character (String type) {
        this(type, 12);
    }

    public Character (String type, int size) {
        setType(type);
        setSize(size);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}