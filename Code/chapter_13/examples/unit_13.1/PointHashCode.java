import java.util.Objects;

public class PointHashCode {
    private String x, y;

    public PointHashCode(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public void setX(String x) {
        this.x = x;
    }
    public String getX() {
        return x;
    }
    public void setY(String y) {
        this.y = y;
    }
    public String getY() {
        return y;
    }


    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof PointHashCode)) {
            return false;
        }
        PointHashCode otherPoint = (PointHashCode) otherObject;
        return Objects.equals(this.x, otherPoint.x) && Objects.equals(this.y, otherPoint.y);
    }

    public static void main(String args[]) {
        PointHashCode p1 = new PointHashCode("5","6");
        PointHashCode p2 = new PointHashCode("1","2");
        PointHashCode p3 = new PointHashCode("2","6");
        System.out.println( p1.hashCode());
        System.out.println( p2.hashCode());
        System.out.println( p3.hashCode());
    }

/* @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }*/
    /* @Override
    public int hashCode() {
        return 31 * (Objects.hashCode(x) + Objects.hashCode(y));
    } */

    @Override
    public int hashCode() {
        return 31 * Objects.hash(x, y);
    }
}