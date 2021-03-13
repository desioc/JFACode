import static java.lang.Math.*;

public class Ruler {
    public static double getDistance(Point p1, Point p2) {
        return sqrt(pow(p1.getX()-p2.getX(), 2) + pow(p1.getY()-p2.getY(), 2)); 
    }
}