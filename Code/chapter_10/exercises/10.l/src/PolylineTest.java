import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PolylineTest {
	private static final String TEST_OK = "TEST OK:\n";
	private static final String TEST_KO = "TEST FALLITO: ";

//    public static void main(String args[]) {
//        testCorrectPolyline();
//        testCorrectPolylineWithFourPoints();
//        testPolylineWithoutSegments();
//        testPolylineWithOneSegment();
//        testPolylineWithTwoNonConsecutiveSegmentsInConstructor();
//        testPolylineWithThreeNonConsecutiveSegmentsInConstructor();
//        testCorrectPolylineAddingAConsecutiveSegment();
//        testInvalidPolylineAddingANonConsecutiveSegment();
//    }

	@Test
	public void testCorrectPolyline() {
		try {
			System.out.println("testCorrectPolyline:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 2);
			Segment s2 = new Segment(p2, p3);
			Polyline pol1 = new Polyline(s1, s2);
			Assert.assertNotNull(pol1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void testCorrectPolylineWithFourPoints() {
		try {
			System.out.println("testCorrectPolylineWithFourPoints:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 1);
			Point p4 = new Point(2, 3);
			Segment s2 = new Segment(p3, p4);
			Polyline pol1 = new Polyline(s1, s2);
			Assert.assertNotNull(pol1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void testPolylineWithoutSegments() {
		try {
			System.out.println("testPolylineWithoutSegments:");
			Polyline pol1 = new Polyline();
			assert false : "A polyline without segments has been created!";
		} catch (Exception exc) {
			Assert.assertNotNull(exc);
			System.out.println(TEST_OK + exc.getMessage());
			System.out.println();
		}
	}

	@Test
	public void testPolylineWithOneSegment() {
		try {
			System.out.println("testPolylineWithOneSegment:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Polyline pol1 = new Polyline(s1);
			System.out.println(TEST_KO + pol1);
			assert false : "A polyline with a single segment has been created!";
		} catch (Exception exc) {
			Assert.assertNotNull(exc);
			System.out.println(TEST_OK + exc.getMessage());
			System.out.println();
		}
	}

	public void testPolylineWithTwoNonConsecutiveSegmentsInConstructor() {
		try {
			System.out.println("testPolylineWithTwoNonConsecutiveSegmentsInConstructor:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 2);
			Point p4 = new Point(2, 2);
			Segment s2 = new Segment(p3, p4);
			Polyline pol1 = new Polyline(s1, s2);
			System.out.println(TEST_KO + pol1);
			assert false : "ÈA polyline with two non-consecutive segments has been created (in the constructor)";
		} catch (Exception exc) {
			Assert.assertNotNull(exc);
			System.out.println(TEST_OK + exc.getMessage());
			System.out.println();
		}
	}

	public void testPolylineWithThreeNonConsecutiveSegmentsInConstructor() {
		try {
			System.out.println("testPolylineWithThreeNonConsecutiveSegmentsInConstructor:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 1);
			Point p4 = new Point(2, 2);
			Segment s2 = new Segment(p3, p4);
			Point p5 = new Point(2, 3);
			Point p6 = new Point(3, 2);
			Segment s3 = new Segment(p5, p6);
			Polyline pol1 = new Polyline(s1, s2, s3);
			System.out.println(TEST_KO + pol1);
			assert false : "A polyline with three non-consecutive segments has been created (in the constructor)!";
		} catch (Exception exc) {
			Assert.assertNotNull(exc);
			System.out.println(TEST_OK + exc.getMessage());
			System.out.println();
		}
	}

	@Test
	public void testCorrectPolylineAddingAConsecutiveSegment() {
		try {
			System.out.println("testCorrectPolylineAddingAConsecutiveSegment:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 2);
			Segment s2 = new Segment(p2, p3);
			Polyline pol1 = new Polyline(s1, s2);
			Point p4 = new Point(3, 2);
			Segment s3 = new Segment(p3, p4);
			pol1.addSegment(s3);
			System.out.println(TEST_OK + pol1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Test
	public void testInvalidPolylineAddingANonConsecutiveSegment() {
		try {
			System.out.println("testInvalidPolylineAddingANonConsecutiveSegment:");
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Segment s1 = new Segment(p1, p2);
			Point p3 = new Point(1, 2);
			Segment s2 = new Segment(p2, p3);
			Polyline pol1 = new Polyline(s1, s2);
			Point p4 = new Point(3, 2);
			Point p5 = new Point(3, 3);
			Segment s3 = new Segment(p4, p5);
			pol1.addSegment(s3);
			System.out.println(TEST_KO + pol1);
			assert false : "A polyline with a non-consecutive segment has been created!";
		} catch (Exception exc) {
			Assert.assertNotNull(exc);
			System.out.println(TEST_OK + exc.getMessage());
		}
	}
}