import java.util.Objects;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

/* @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (otherObject instanceof Point) {
            Point otherPoint = (Point) otherObject;
            return this.x == otherPoint.x && this.y == otherPoint.y;
        } else {
            return false;
        }
    }
    */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) otherObject;
        return Objects.equals(this.x, otherPoint.x) && Objects.equals(this.y, otherPoint.y);
    }
    @Override
    public int hashCode() {
        return x ^ y;
    }

    public static void main(String args[]) {
        String s = "2" + "5";

        Point p1 = new Point(5,6);
        Point p2 = new Point(5,2);
        Point p3 = new Point(5,6);
        s+="opjdfgjisd";
        System.out.println( s);
        System.out.println( p1.equals(p2));
        System.out.println( p1.equals(p3));
        System.out.println( p1.equals(""));

        System.out.println( p1.hashCode());
        System.out.println( p2.hashCode());
        System.out.println( p3.hashCode());
    }
}