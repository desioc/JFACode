public class Point {
    private String name;
    private int x;
    private int y;

    public Point (String name, int x, int y) {
        setName(name);
        setX(x);
        setY(y);
    }

    public Point (int x, int y) {
        this("", x, y);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return name + "("+x+","+ y +")";
    }
}