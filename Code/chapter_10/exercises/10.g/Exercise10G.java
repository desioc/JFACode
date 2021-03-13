import java.util.*;
import javax.swing.*;

public class Exercise10G {
    private Scanner scanner;
    private CartesianPlane cartesianPlane;

    public Exercise10G () {
        scanner = new Scanner(System.in);
    }
    
    public void start() {
        SwingUtilities.invokeLater(() -> cartesianPlane = new CartesianPlane());
        Point p1 = getPoint("P1");
        cartesianPlane.drawPoint(p1);
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
        Exercise10G exercise10G = new Exercise10G();
        exercise10G.start();
    }
}