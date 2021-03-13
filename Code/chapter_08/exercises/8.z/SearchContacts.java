package phonebook.ui;

import phonebook.data.*;
import phonebook.business.User;
import java.util.Scanner;


public class SearchContacts {
    public static void main(String args[]) {
        System.out.println("Search Contacts");
        System.out.println();
        var user = new User();
        Contact newContact = ContactFactory.getContact(
            "Molly Malone", "123456789", 
            "Suffolk St, Dublin 2, D02 KX03, Ireland");
        Special specialContact = ContactFactory.getContact(
            "Phil Lynott", "987654321", "Harry St, Dublin, Ireland", "Rosalie");
        user.add(newContact);
        user.add(specialContact);
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