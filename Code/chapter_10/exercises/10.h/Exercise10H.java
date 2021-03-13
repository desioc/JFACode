import java.util.*;
import javax.swing.*;

public class Exercise10H {
    private Scanner scanner;
    private CartesianPlane cartesianPlane;
    private static int counter = 1;

    public Exercise10H () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        SwingUtilities.invokeLater(() -> cartesianPlane = new CartesianPlane());
        while(true) {
            Point p1 = getPoint("P"+(counter++));
            cartesianPlane.drawPoint(p1);
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
        Exercise10H exercise10H = new Exercise10H();
        exercise10H.start();
    }
}