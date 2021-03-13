public class IntersectionTypeTest {
    public static void main(String args[]) {
        Plane piper = new Plane();
        Traveler claudio = new Traveler();
        claudio.travel(piper);
        Flying baloon = new Baloon();
        claudio.travel(baloon);
    }
}