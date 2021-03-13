import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise10D {
    private Scanner scanner;

    public Exercise10D () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            Point p1 = getPoint("1");
            Point p2 = getPoint("2");
            printDistance(p1, p2) ;
        }
        catch (InputMismatchException exc) {
            System.out.println("All coordinates must be integers!");
        }
    }

    private int getCoordinate(String coordinateName, String pointName) {
        System.out.println("Enter the coordinate "+ coordinateName +" of point "+ pointName);
        return scanner.nextInt();
    }

    private Point getPoint(String pointName) {
        int x = getCoordinate("x", pointName);
        int y = getCoordinate("y", pointName);
        Point p = new Point(x,y);
        System.out.println("Point created: "+ p);
        return p;
    }

    public void printDistance(Point p1, Point p2) {
        System.out.println("Distance between two points: "+ p1 +" and "+ p2 +" = "+ Ruler.getDistance(p1,p2));
    }

    public static void main(String args[]) {
        Exercise10D exercise10D = new Exercise10D();
        exercise10D.start();
    }
}