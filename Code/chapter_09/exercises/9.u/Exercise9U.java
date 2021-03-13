public class Exercise9U {
    public static void main(String args[]) {
        try (SlidingDoor slidingDoor = new SlidingDoor();) {
            slidingDoor.open();
        }
    }
}