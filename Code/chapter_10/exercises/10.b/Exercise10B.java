public class Exercise10B {
    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Insert 4 coordinates to calculate the distance between two points");
        }
        try {
            Point p1 = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            Point p2 = new Point(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            System.out.println("Distance between two points: "+ p1 +" and "+ p2 +" = "+ Ruler.getDistance(p1, p2));
        }
        catch (NumberFormatException exc) {
            System.out.println("All coordinates must be integers! Error: "+ exc.getMessage());
        }
    }
}