public class TravelerTest {
    public static void main(String args[]) {
        Traveler claudio = new Traveler();
        Car fiat500 = new Car();
        // we should have created also a Boat or a Plane
        claudio.travel(fiat500);
        Plane piper = new Plane();
        claudio.travel(piper);
    }
}