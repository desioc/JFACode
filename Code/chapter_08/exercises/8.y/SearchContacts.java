package phonebook.ui;

import phonebook.data.*;
import phonebook.business.User;
import java.util.Scanner;


public class SearchContacts {
    public static void main(String args[]) {
        System.out.println("Search Contacts");
        System.out.println();
        var user = new User();
        System.out.println("Enter name or part of the name to be searched");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Contact[] foundContacts = user.searchContactsByName(input);
        System.out.println("Contacts found with name containing \"" + input +"\"" );
        for (Contact contact : foundContacts) {
            if (contact != null) {
                System.out.println(contact+"\n");
            }
        }
    }
}