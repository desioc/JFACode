public class PrintContactsV2 {
    public static void main(String args[]) {
        System.out.println("Contacts List");
        System.out.println();
        Contact contact1 = new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313");
        Contact contact2 = new Contact("Stevie Wonder", "10, Music Avenue", "1010101010");
        Contact contact3 = new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square", "1111111111");
        contact1.printDetails();
        contact2.printDetails();
        contact3.printDetails();
    }
}