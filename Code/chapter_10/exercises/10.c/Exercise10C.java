import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise10C {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the x coordinate of the first point");
            int x1 = scanner.nextInt();
            System.out.println("Enter the y coordinate of the first point");
            int y1 = scanner.nextInt();
            Point p1 = new Point(x1, y1);
            System.out.println("Point created:"+ p1);
            System.out.println("Enter the x coordinate of the second point");
            int x2 = scanner.nextInt();
            System.out.println("Enter the y coordinate of the second point");
            int y2 = scanner.nextInt();
            Point p2 = new Point(x2, y2);
            System.out.println("Point created:"+ p2);
            System.out.println("Distance between two points: "+ p1 +" and "+ p2 +" = "+ Ruler.getDistance(p1,p2));
        } catch (InputMismatchException exc) {
            System.out.println("All coordinates must be integers!");
        }
    }
}