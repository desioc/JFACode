public class PrintContacts {
    public static void main(String args[]) {
        System.out.println("Contacts List");
        System.out.println();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.contact1.printDetails();
        phoneBook.contact2.printDetails();
        phoneBook.contact3.printDetails();
    }
}