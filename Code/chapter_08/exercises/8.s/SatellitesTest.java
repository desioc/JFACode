public class SatellitesTest {
    public static void main(String args[]) {
        test(new Moon(), new ArtificialSatellite());
        Satellite[] satellites = {
            new Moon(), new ArtificialSatellite()
        } ;
        test(satellites);
        test();
      //  test(new Object());
    }

    public static void test(Satellite... satellites) {
        for (Satellite satellite : satellites) {
            satellite.orbit();
        }
    }
}