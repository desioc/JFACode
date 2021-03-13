public class ThreeDimensionalPoint extends Point {
    private int z;
    public ThreeDimensionalPoint() {
        //Constructor without parameters
    }
    public ThreeDimensionalPoint(int x, int y, int z) {
        this.setXYZ(x, y, z); //Code reuse
    }
    public void setZ(int z) {
        this.z = z; //this is mandatory
    }
    public void setXYZ(int x, int y, int z) {
        this.setXY(x, y); ///Code reuse
        this.setZ(z); //this is optional
    }
    public int getZ() {
        return this.z; //this is optional
    }
    @Override
    public double distance(Point p) {
        if (p instanceof ThreeDimensionalPoint) {
            //Call to a private method using casting
            return this.calculateDistance((ThreeDimensionalPoint)p);
        }
        else {
            return -1; //distance not valid!
        }
    }
    private double calculateDistance(ThreeDimensionalPoint p1) {
        //square of the difference of the x of the two points
        int tmp1=(getX()-p1.getX())*(getX()-p1.getX());
        //square of the difference of the y of the two points
        int tmp2=(getY()-p1.getY())*(getY()-p1.getY());
        //square of the difference of the z of the two points
        int tmp3=(z-p1.z)*(z-p1.z);
        //square root of the sum of the three squares
        return Math.sqrt(tmp1+tmp2+tmp3);
    }
    
   /* @Override
    public double distance (ThreeDimensionalPoint p) {
        //square of the difference of the x of the two points
        int tmp1=(getX()-p.getX())*(getX()-p.getX());
        //square of the difference of the y of the two points
        int tmp2=(getY()-p.getY())*(getY()-p.getY());
        //square of the difference of the z of the two points
        int tmp3=(z-p.z)*(z-p.z);
        //square root of the sum of the three squares
        return Math.sqrt(tmp1+tmp2+tmp3);
    } */

    
    /* @Override
    public double distance(Point p) {
        if (p instanceof ThreeDimensionalPoint) {
            //square of the difference of the x of the two points
            int tmp1=(getX()-p1.getX())*(getX()-p1.getX());
            //square of the difference of the y of the two points
            int tmp2=(getY()-p1.getY())*(getY()-p1.getY());
            //square of the difference of the z of the two points
            int tmp3=(z-p1.z)*(z-p1.z);
            //square root of the sum of the three squares
            return Math.sqrt(tmp1+tmp2+tmp3);
        }
        else {
            return -1; //distance not valid!
        }
    } */

}