public class FlyingVehiclesFactoryTest {
    public static void main(String args[]) {
        var factory = new FlyingVehiclesFactory();
        Vehicle vehicle = factory.getFlyingVehicle();
        vehicle.accelerate();
        //vehicle.takeOff(); does not compile!
        Flying flying = factory.getFlyingVehicle();
        //flying.accelerate(); does not compile!
        flying.takeOff();
        var vehicleFlying = factory.getFlyingVehicle();
        vehicleFlying.accelerate();
        vehicleFlying.takeOff();
    }
}