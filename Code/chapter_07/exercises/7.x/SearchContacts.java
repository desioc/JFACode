import java.util.Scanner;

public class SearchContacts {
    public static void main(String args[]) {
		  System.out.println("Search Contacts");
        System.out.println();
        var phoneBook = PhoneBook.getInstance();
        System.out.println("Enter name or part of the name to be searched");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Contact[] foundContacts = phoneBook.searchContactsByName(input);
        System.out.println("Contacts found with name containing \"" + input +"\"" );
        for (Contact contact : foundContacts) {
            if (contact != null) {
                contact.printDetails();
            }
        }
    }
}