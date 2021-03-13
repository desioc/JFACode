public class Exercise10A {
private final static double CORRECT_RESULT = 2;
    public static void main(String args[]) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(2,0);
        double distance = Ruler.getDistance(p1,p2);
        System.out.println("Distance between points: " + p1 + " e " + p2 + " = " + distance);
        assert distance == CORRECT_RESULT : "Error! The result should be " 
            + CORRECT_RESULT;
        System.out.println("Correct distance!");
    }
}