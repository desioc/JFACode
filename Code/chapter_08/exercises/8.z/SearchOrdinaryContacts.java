package phonebook.ui;
import phonebook.data.*;
import phonebook.business.User;
import java.util.Scanner;

public class SearchOrdinaryContacts {
    public static void main(String args[]) {
        System.out.println("Search Ordinary Contacts");
        System.out.println();
        var user = new User();
        System.out.println("Enter name or part of the name to be searched");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Contact[] ordinaryContactsFound = user.searchOrdinaryContactsByName(input);
        System.out.println("Ordinary Contacts found with name containing \"" + input +"\"");
        for (Contact ordinary : ordinaryContactsFound) {
            if (ordinary != null) {
                System.out.println(ordinary+"\n");
            }
        }
    }
}