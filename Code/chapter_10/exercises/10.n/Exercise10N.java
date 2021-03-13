import java.util.*;
import javax.swing.*;

public class Exercise10N {
    private Scanner scanner;
    private CartesianPlane cartesianPlane;
    private Point lastExtreme;
    private static int counter = 1;

    public Exercise10N () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        SwingUtilities.invokeLater(() -> cartesianPlane = new CartesianPlane());
        System.out.println("Let's define the first two segments of a polyline:");
        System.out.println("Define the first extreme point of the first segment of the polyline:");
        Point p1 = getPoint("P"+(counter++));
        System.out.println("Define the second extreme point of the first segment of the polyline:");
        createSegment(p1);
        /* Point p2 = getPoint("P"+(counter++));
        Segment s1 = new Segment(p1, p2); 
        cartesianPlane.drawSegment(s1);*/
        System.out.println("Define the second extreme point of the second segment of the polyline:");
        createSegment(lastExtreme);
        /* Point p3 = getPoint("P"+(counter++));
        Segment s2 = new Segment(p2, p3);
        cartesianPlane.drawSegment(s2); 
        Point lastExtreme = p3;*/
        while(true) {
            /* Point nextExtreme = getPoint("P"+(counter++));
            Segment nextSegment = new Segment(lastExtreme, nextExtreme);
            cartesianPlane.drawSegment(nextSegment);
            lastExtreme = nextExtreme; */
            createSegment(lastExtreme);
        }
    }

    public void createSegment(Point firstExtreme) {
        try {
            lastExtreme = getPoint("P"+(counter++));
            Segment segment = new Segment(firstExtreme, lastExtreme);
            cartesianPlane.drawSegment(segment);
        } catch (InvalidSegmentException exc) {
            System.out.println(exc);
            counter--;
            createSegment(firstExtreme);
        }
    }

    private int getCoordinate(String coordinateName, String pointName) {
        System.out.println("Edit coordinate "+ coordinateName +" of the extreme point "+ pointName);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid coordinate "+  scanner.next() +"! All coordinates must be integers! Please enter only integers");
            }
        }
        return -1;
    }

    private Point getPoint(String pointName) {
        int x = getCoordinate("x", pointName);
        int y = getCoordinate("y", pointName);
        Point p = new Point(x,y);
        System.out.println("Point created: "+ p);
        return p;
    }


    public static void main(String args[]) {
        Exercise10N exercise10N = new Exercise10N();
        exercise10N.start();
    }
}