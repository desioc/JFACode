public class TryWithResourceSuppressedTest {
    public static void main(String args[]) {
        try (var almostCloseableResource = new AlmostCloseableResource()) {
            System.out.println("I'm going to close: "+ almostCloseableResource);
            almostCloseableResource.launchException();
        }
        catch (Exception exc) {
            exc.printStackTrace();
            Throwable[] suppressedExceptions = exc.getSuppressed();
            for (Throwable exception : suppressedExceptions) {
                System.err.println("SUPPRESSED EXCEPTION: "+ exception.toString());
            }
        }
    }
}