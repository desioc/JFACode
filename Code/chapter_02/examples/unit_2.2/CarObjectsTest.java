public class CarObjectsTest {
    public static void main(String args[]) {
        Car fiat500;
        fiat500 = new Car();
        fiat500.engineCapacity = 900;
        fiat500.move();
        Car ferrariCalifornia = new Car();
        ferrariCalifornia.engineCapacity = 4300;
        ferrariCalifornia.move();
    }
}