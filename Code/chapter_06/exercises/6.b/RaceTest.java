public class RaceTest {
    public static void main(String args[]) {
        Race monteCarlo = new Race("Montecarlo GP");
        monteCarlo.runRace();
        String result = monteCarlo.getResult();
        System.out.println(result);
    }
}