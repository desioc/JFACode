public class FlyingAnonymousTest {
    public static void main(String args[]) {
        Flying ufo = new Flying() {
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
        } ;
        //Let's use the object from the anonymous class.
        ufo.takeOff();
        ufo.glide();
        ufo.land();
    }
}