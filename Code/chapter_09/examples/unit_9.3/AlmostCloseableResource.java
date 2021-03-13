public class AlmostCloseableResource extends CloseableResource {
    private Number number;
    @Override
    public void close() {
        super.close();
        number = Double.valueOf(.1);   
        Integer integer = (Integer)number;
    }
    
    public void launchException() {
        number = Integer.valueOf("Something is really wrong!");
    }
    
    @Override
    public String toString() {
        return "AlmostCloseableResource";
    }
}