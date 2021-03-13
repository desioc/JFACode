public class Traveler {
     public  <T extends Vehicle & Flying> void travel(T t) { //polymorphic parameter
        t.accelerate(); //virtual invocation of the method
        t.takeOff();//virtual invocation of the method
        //. . .
    } 
     /* public  void travel(FlyingVehicle t) { //polymorphic parameter
        t.accelerate(); //virtual invocation of the method
        t.takeOff();
        //. . .
    } */
/* public  <T extends Vehicle & Flying & Electric> void travel(T t) { //polymorphic parameter
        t.accelerate(); //virtual invocation of the method
        t.takeOff();//virtual invocation of the method
        //. . .
    } */    //. . .
}