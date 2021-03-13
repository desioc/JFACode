public class TryWithResource2Test {
    public static void main(String args[]) {
        var closeableResource = new CloseableResource();
        try (closeableResource) {
            System.out.println("I'm going to close: "+ closeableResource);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}