public class PilotTest {
    public static void main(String args[]) {
        Pilot pilot = new Pilot("Simone");
        pilot.go(new Flying() {
             @Override
            public void takeOff() {
                System.out.println("An undentified flying object is taking off");
            }
            @Override
            public void glide() {
                System.out.println("An undentified flying object is gliding");
            }
            @Override
            public void land() {
                System.out.println("An undentified flying object is landing...");
            }
        } );
    }
}