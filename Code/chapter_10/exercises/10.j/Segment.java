public class Segment {
    private Point extremePoint1;
    private Point extremePoint2;

    private double length;

    public Segment(Point extremePoint1, Point extremePoint2 ) {
        this.extremePoint1 = extremePoint1;
        this.extremePoint2 = extremePoint2;
        setLength();
    }

    public Point getExtremePoint1() {
        return extremePoint1;
    }

    public Point getExtremePoint2() {
        return extremePoint2;
    }

    private void setLength() {
        this.length = Ruler.getDistance(extremePoint1, extremePoint2);
    }

    public String toString() {
        return "Segment from P1"+extremePoint1+" to P2"+extremePoint2 + " with length = " + length;
    }
}