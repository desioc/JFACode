public class BoxOffice {
    private int availableSeats;
    public BoxOffice() {
        availableSeats = 100;
    }
    public void book() throws BookingException {
        //try {
            //seats availability check
        if (availableSeats == 0) {
                //throw the exception
            throw new BookingException();
        }
            //method that realize the booking
            //if no exception is thrown
        availableSeats--;
        /* }
        catch (BookingException exc) {
            System.out.println(exc.toString());
        }*/
    }
   public void bookWithSwitchExpression() throws BookingException {
        availableSeats = switch(availableSeats) {
            default -> availableSeats-1;
            case 0 -> throw new BookingException();
        } ;
    } 
}