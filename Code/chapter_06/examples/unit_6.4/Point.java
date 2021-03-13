public class Point {
    private int x, y;
    private final int MAX_VALUE_FOR_X=10 ;
    private final int MIN_VALUE_FOR_X=-10 ;
    private final int MAX_VALUE_FOR_y=10 ;
    private final int MIN_VALUE_FOR_Y=-10 ;
    public void setX(int a) {
        if (a <= MAX_VALUE_FOR_X && a >= MIN_VALUE_FOR_X) {
            x = a;
            System.out.println("X is OK!");
        }
        else {
            System.out.println("X is not valid");
        }
    }
    public void setY(int a) {
        if (a <= MAX_VALUE_FOR_y && a >= MIN_VALUE_FOR_Y) {
            y = a;
            System.out.println("Y is OK!");
        }
        else {
            System.out.println("Y is not valid");
        }
    }
    //   . . .
}