public class TryWithResourceTest {
    public static void main(String args[]) {
        try (var closeableResource = new CloseableResource()) {
            System.out.println("I'm going to close: "+ closeableResource);
            closeableResource.launchException();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}