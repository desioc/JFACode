public class FlyingVehiclesFactory {
    public  <T extends Vehicle & Flying> T getFlyingVehicle() {
        return (T) new Plane();
    }
}