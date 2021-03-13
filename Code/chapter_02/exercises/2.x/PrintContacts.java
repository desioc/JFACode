public class PrintContacts {
    public static void main(String args[]) {
        System.out.println("Contacts List");
        System.out.println();
        Contact contact1 = new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313");
        Contact contact2 = new Contact("Stevie Wonder", "10, Music Avenue", "1010101010");
        Contact contact3 = new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square" ,"1111111111");
        System.out.println(contact1.name);
        System.out.println(contact1.address);
        System.out.println(contact1.phoneNumber);
        System.out.println();
        System.out.println(contact2.name);
        System.out.println(contact2.address);
        System.out.println(contact2.phoneNumber);
        System.out.println();
        System.out.println(contact3.name);
        System.out.println(contact3.address);
        System.out.println(contact3.phoneNumber);
    }
}