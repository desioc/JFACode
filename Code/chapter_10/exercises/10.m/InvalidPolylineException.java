import java.util.List;

public class InvalidPolylineException extends Exception {
    public InvalidPolylineException (List<Segment> segments) {
        super(segments.size() < 2 ? "A polyline must consist of at least 2 segments"
        : "These segments " + segments + " do not constitute a polyline");
    }
        
    public String toString() {
        return "Invalid polyline:\n" + getMessage();
    }
}