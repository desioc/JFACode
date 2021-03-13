public class BookingManager {
    public static void main(String [] args) {
        var boxOffice = new BoxOffice();
        try {
            for (int i = 1; i <= 101; ++i) {
                //boxOffice.book();
                boxOffice.bookWithSwitchExpression();
                System.out.println("Seat booked n° " + i);
            }
        }
        catch (BookingException exc) {
            System.out.println(exc.toString());
        }
    }
}