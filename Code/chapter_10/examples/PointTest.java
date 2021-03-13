import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void testDistanceOnX() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);
        double distance = p1.distance(p2);
        Assert.assertTrue(distance == 1);
    }
    @Test
    public void testDistanceWithNull() {
        Point p1 = new Point(1,1);
        Point p2 = null;
        double distance = p1.distance(p2);
        Assert.assertTrue(distance == -1);
    }
    @Test
    public void testDistanceFromTheSamePoint() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        double distance = p1.distance(p2);
        Assert.assertTrue(distance == 0);
    }
    @Test
    public void testDistanceFromAThreeDimensionalPoint() {
        Point p1 = new Point(1,1);
        Point p2 = new ThreeDimensionalPoint(1,2,2);
        double distance = p1.distance(p2);
        Assert.assertTrue(distance == -1);
    }
}