import java.util.*;
import javax.swing.*;

public class Exercise10I {
    private Scanner scanner;
    private CartesianPlane cartesianPlane;
    private static int counter = 1;

    public Exercise10I () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        SwingUtilities.invokeLater(() -> cartesianPlane = new CartesianPlane());
        while(true) {
            System.out.println("Define a segment");
            Point p1 = getPoint("P"+(counter++));
            Point p2 = getPoint("P"+(counter++));
            Segment s1 = new Segment(p1, p2);
            cartesianPlane.drawSegment(s1);
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
        Exercise10I exercise10I = new Exercise10I();
        exercise10I.start();
    }
}