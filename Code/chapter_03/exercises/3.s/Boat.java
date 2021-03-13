public class Boat {
    int index = 0;
    public Car[] carArray;

    public Boat () {
        carArray = new Car[100];
    }

    public void loadCar(Car car) {
        carArray[index] = car;
        System.out.println("Car: "+ car.type +" loaded");
        index++;
    }
}