package workers;
import parking.Car;

public class Driver {
    public void drive(Car car) {
        System.out.println("I'm driving a " + car.type + " car" );
    }
}