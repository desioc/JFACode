public class TreeDimensionalPoint extends Point {
    private int z;

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public double distanceFromOrigin() {
        int tmp = (getX()*getX()) + (getY()*getY())
           + (z*z); // x e y  are not inherited
        return Math.sqrt(tmp);
    }
//this cause an error
//    public class TreeDimensionalPoint extends Point {
//        @Override
//        public double distanceFromOrigin() {//it should be distanceFromOrigin()!
      //. . .
//        }
//    }
}