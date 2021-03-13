public class WrapperException {
    private Exception otherException;
    public WrapperException(Exception otherException) {
        this.setOtherException(otherException);
    }
    public void setOtherException(Exception otherException) {
        this.otherException = otherException;
    }
    public Exception getOtherException() {
        return otherException;
    }
    //...
}