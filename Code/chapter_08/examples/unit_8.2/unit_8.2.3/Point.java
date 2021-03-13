public class Point {
    private int x, y;

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
    public double distanceFromOrigin() {
        int tmp = (x*x) + (y*y);
        return Math.sqrt(tmp);
    }
//first rule    
//    public void setCoordinates(int x, int y) {
//        setX(x);
//        setY(y);
//    }

//second rule
//   public Point processPoint() {
    // . . .
//    }
}