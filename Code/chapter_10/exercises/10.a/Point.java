public class Point {
    private int x;
    private int y;

    public Point (int x, int y) {
        setX(x);
        setY(y);
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
        return "("+x+"," + y + ")";
    }
}