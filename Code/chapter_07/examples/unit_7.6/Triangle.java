public class Triangle extends Polygon {
    public static final int SIDES_NUMBER = 3;
    
    public Triangle () {
        super(SIDES_NUMBER);
    }

    public Triangle (int sideOneLength, int sideTwoLength, int sideThreeLength) {
        super(SIDES_NUMBER, sideOneLength, sideTwoLength, sideThreeLength);
    }
    
    public String toString(){
        return "The triangle has " + super.toString();
    }
}