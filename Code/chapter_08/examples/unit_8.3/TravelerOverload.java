public class TravelerOverload {
    public void travel(Car a) {
        a.accelerate();
        //. . .
    }
    public void travel(Plane a) {
        a.accelerate();
        //. . .
    }
    public void travel(Boat n) {
        n.accelerate();
        //. . .
    }
    //. . .
}