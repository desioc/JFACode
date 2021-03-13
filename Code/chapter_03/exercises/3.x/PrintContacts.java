public class PrintContacts {
    public static void main(String args[]) {
        System.out.println("Contacts List");
        System.out.println();
        var phoneBook = new PhoneBook();
        phoneBook.contacts[0].printDetails();
        phoneBook.contacts[1].printDetails();
        phoneBook.contacts[2].printDetails();
    }
}