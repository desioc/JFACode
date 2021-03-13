public class Exercise3S {
    public static void main(String args[]) {
        Boat boat = new Boat();
        Car car1 = new Car("Renault");
        Car car2 = new Car("Volkswagen");
        Car car3 = new Car("Nissan");
        boat.loadCar(car1);
        boat.loadCar(car2);
        boat.loadCar(car3);
    }
}