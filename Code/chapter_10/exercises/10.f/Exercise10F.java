import java.util.*;

public class Exercise10F {
    private Scanner scanner;

    public Exercise10F () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Please define a segment specifying its extreme points:");
        Point p1 = getPoint("1");
        Point p2 = getPoint("2");
        print(new Segment(p1, p2) );
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

    public void print(Segment segment) {
        System.out.println(segment);
    }

    public static void main(String args[]) {
        Exercise10F exercise10F = new Exercise10F();
        exercise10F.start();
    }
}