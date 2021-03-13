public class SlidingDoor implements AutoCloseable {
    public void close(){
        System.out.println("The door is closing");
    }

    public void open(){
        System.out.println("The door is opening");
    }
}