public abstract class Polygon {
    private int sidesNumber;
    private int sideOneLength;
    private int sideTwoLength;
    private int sideThreeLength;

    public Polygon(int sidesNumber) {
        setSidesNumber(sidesNumber);
    }

    public Polygon(int sidesNumber, int sideOneLength, int sideTwoLength, int sideThreeLength) {
        setSidesNumber(sidesNumber);
        setSidesOneLength(sideOneLength);
        setSidesTwoLength(sideTwoLength);
        setSidesThreeLength(sideThreeLength);
    }

    public void setSidesNumber(int sidesNumber) {
        this.sidesNumber = sidesNumber;
    }

    public int getSidesNumber() {
        return sidesNumber;
    }
    
    public void setSidesThreeLength(int sideThreeLength) {
        this.sideThreeLength = sideThreeLength;
    }

    public int getSidesThreeLength() {
        return sideThreeLength;
    }

    public void setSidesTwoLength(int sideTwoLength) {
        this.sideTwoLength = sideTwoLength;
    }

    public int getSidesTwoLength() {
        return sideTwoLength;
    }


    public void setSidesOneLength(int sideOneLength) {
        this.sideOneLength = sideOneLength;
    }

    public int getSidesOneLength() {
        return sideOneLength;
    }
    
    public String toString(){
        return sidesNumber + " sides: side one length = " + sideOneLength 
        + ", side two length = " + sideTwoLength + ", side three length = " + sideThreeLength;
    }
}