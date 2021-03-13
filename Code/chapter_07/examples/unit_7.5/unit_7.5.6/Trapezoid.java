public class Trapezoid extends Polygon {
    public static final int SIDES_NUMBER = 4;
    private int sideFourLength;

    public Trapezoid() {
        super(SIDES_NUMBER) ;
    }

    public Trapezoid(int sideOneLength, int sideTwoLength, int sideThreeLength, int sideFourLength) {
        super(SIDES_NUMBER, sideOneLength, sideTwoLength, sideThreeLength);
        setSideFourLength(sideFourLength);
    }
    public void setSideFourLength(int sideFourLength) {
        this.sideFourLength = sideFourLength;
    }

    public int getSideFourLength() {
        return sideFourLength;
    }
    
    public String toString(){
        return "The trapeze has " + super.toString() + ", side four length = " + sideFourLength;
    }
}