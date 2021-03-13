package phonebook.ui;
import phonebook.data.*;
import phonebook.business.User;
import java.util.Scanner;

public class SearchSpecialContacts {
    public static void main(String args[]) {
        System.out.println("Search Special Contacts");
        System.out.println();
        var user = new User();
        System.out.println("Enter name or part of the name to be searched");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Special[] specialContactsFound = user.searchSpecialContactsByName(input);
        System.out.println("Special Contacts found with name containing \"" + input +"\"");
        for (Special special : specialContactsFound) {
            if (special != null) {
                special.printDetails();
            }
        }
    }
}