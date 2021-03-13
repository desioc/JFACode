import java.util.*;

public class Polyline {
    private List<Segment> segmentList;

    public Polyline (Segment... segments) throws InvalidPolylineException {
        this.segmentList = new ArrayList(Arrays.asList(segments));
        if (segments.length < 2 || !checkConsecutiveSegments()) {
            throw new InvalidPolylineException(segmentList);
        }
    }

    public void addSegment(Segment newSegment) throws InvalidPolylineException {
        Segment lastSegment = segmentList.get(segmentList.size()-1);
        Point lastSegmentExtremePoint2 = lastSegment.getExtremePoint2();
        Point newSegmentExtremePoint1 = newSegment.getExtremePoint1();
        segmentList.add(newSegment);
        if (!equal(newSegmentExtremePoint1, lastSegmentExtremePoint2)) {
            throw new InvalidPolylineException(segmentList);
        }
    }

    private boolean checkConsecutiveSegments() {
        int segmentListSize = segmentList.size();
        for (int i = 0; i < segmentListSize-1; ) {
            Point previousSegmentExtremePoint2 = segmentList.get(i++).getExtremePoint2();
            Point nextSegmentExtremePoint1 = segmentList.get(i).getExtremePoint1();
            if (!equal(previousSegmentExtremePoint2, nextSegmentExtremePoint1)) {
                return false;
            }
        }
        return true;
    }

    private boolean equal(Point p1, Point p2) {
        return p1.getX()==p2.getX() && p1.getY()== p2.getY();
    }

    public String toString() {
        String descrizione ="Polyline defined by:\n";
        for (Segment segment : segmentList) {
            descrizione += segment +"\n";
        }
        return descrizione;
    }
}