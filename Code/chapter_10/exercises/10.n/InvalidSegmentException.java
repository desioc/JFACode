public class InvalidSegmentException extends Exception {
        
    public String toString() {
        return "The extreme points of a segment cannot coincide!";
    }
}