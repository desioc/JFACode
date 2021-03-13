public class ITryWithReferences2 {
    public void changeReference(Date date) {
        date.day = 12; // date and birthday reference to the same address
        date.month = 11;  
        date.year = 2006;
    }
}