public class GeometricTest {
    public static void main(String args[]) {
        /* Declaring the local variables */
        Point p1 = null, p2 = null;
        /* testing if this program has been called specifying the 
        right number of arguments from the command line*/
        if (args.length == 4) {
            //Get integers from strings
            int p1X = Integer.parseInt(args[0]);
            int p1Y = Integer.parseInt(args[1]);
            int p2X = Integer.parseInt(args[2]);
            int p2Y = Integer.parseInt(args[3]);
            //Creating two points
            p1 = new Point(p1X, p1Y);
            p2 = new Point(p2X, p2Y);
        }
        else if (args.length == 6) {
            //Get integers from strings
            int p1X = Integer.parseInt(args[0]);
            int p1Y = Integer.parseInt(args[1]);
            int p1Z = Integer.parseInt(args[3]);
            int p2X = Integer.parseInt(args[4]);
            int p2Y = Integer.parseInt(args[5]);
            int p2Z = Integer.parseInt(args[6]);
            //Creating two points
            p1 = new ThreeDimensionalPoint(p1X, p1Y, p1Z);
            p2 = new ThreeDimensionalPoint(p2X, p2Y, p2Z);
        }
        else {
            System.out.println(
            "insert  4 or 6 arguments");
            System.exit(0); // Application exit
        }
        //Print the distance
        System.out.println("the distance is "
        + p1.distance(p2));
    }
}