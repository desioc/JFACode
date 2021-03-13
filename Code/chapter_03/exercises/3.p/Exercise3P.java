package exercises;
//Insert your code here
import parking.Car; 
import workers.Driver;

public class Exercise3P {

    public static void main(String args[]) {
        Car car = new Car("Toyota Yaris");
        Driver driver = new Driver();
        driver.drive(car);
    }
}