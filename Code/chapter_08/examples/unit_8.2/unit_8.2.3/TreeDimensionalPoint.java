public class TreeDimensionalPoint extends Point {
    private int z;

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public double distanceFromOrigin() {
        int tmp = (getX()*getX()) + (getY()*getY())
           + (z*z); // x and y  are not inherited 
        return Math.sqrt(tmp);
    }

//first rule
//    public void setCoordinates(int x, int y, int z) {
//        super.setCoordinates(x, y);
//        setZ(z);
//    }

//second rule
//public TreeDimensionalPoint processPoint() {
    // . . .
//}

}