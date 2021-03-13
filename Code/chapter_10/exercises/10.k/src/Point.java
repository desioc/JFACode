
public class Point {
    private int x, y;
    public Point() {
        //Constructor without parameters
    }
    public Point(int x, int y) {
        this.setXY(x, y); //this is optional
        //code reuse
    }
    public void setX(int x) {
        this.x = x; //this is mandatory
    }
    public void setY(int y) {
        this.y = y; //this is mandatory
    }
    public void setXY(int x, int y) {
        this.setX(x); //this is optional
        this.setY(y);
    }
    public int getX() {
        return this.x; //this is optional
    }
    public int getY() {
        return this.y; //this is optional
    }
    public double distance(Point p) {
        //square of the difference of the x of the two points
        int tmp1 = (x - p.x)*(x - p.x);
        //square of the difference of the y of the two points
        int tmp2 = (y - p.y)*(y - p.y);
        //square root of the sum of the two squares
        return Math.sqrt(tmp1 + tmp2);
    }
}