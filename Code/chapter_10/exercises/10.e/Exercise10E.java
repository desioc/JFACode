import java.util.Scanner;

public class Exercise10E {
    private Scanner scanner;

    public Exercise10E () {
        scanner = new Scanner(System.in);
    }

    public void start() {
        Point p1 = getPoint("1");
        Point p2 = getPoint("2");
        printDistance(p1, p2) ;
    }

    private int getCoordinate(String coordinateName, String pointName) {
        System.out.println("Enter the coordinate "+ coordinateName +" of point "+ pointName);
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

    public void printDistance(Point p1, Point p2) {
        System.out.println("Distance between two points: "+ p1 +" and "+ p2 +" = "+ Ruler.getDistance(p1,p2));
    }

    public static void main(String args[]) {
        Exercise10E exercise10E = new Exercise10E();
        exercise10E.start();
    }
}