public class Traveler {
    public void travel(Vehicle v) { //polymorphic parameter
        v.accelerate(); //virtual invocation of the method
        //. . .
    }
    //. . .
}