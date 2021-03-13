package phonebook.test;

import phonebook.presentation.*;
import phonebook.data.*;
import phonebook.exceptions.*;
import java.util.*;

public class Exercise20N {
    
    private void executeTest() {
        PhonebookCLI cli = new PhonebookCLI();
        cli.showContacts(getContacts());
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact("Daniele", "01234560", "Guitars Street 1");
        Contact contact2 = new Contact("Giovanni", "0565432190", "Sciences Square 2");
        Contact contact3 = new Contact("Ligeia", "07899921", "Secrets Avenue 3");
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        return contacts;
    }

    public static void main(String args[]) {
        Exercise20N exercise20N = new Exercise20N();
        exercise20N.executeTest();
    }
}