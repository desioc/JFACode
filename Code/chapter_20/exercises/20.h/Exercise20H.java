package phonebook.test;

import phonebook.exceptions.*;
import phonebook.integration.*;
import phonebook.data.*;

public class Exercise20H {
    private FileManager fileManager;
    private Contact[] contacts;

    Exercise20H() {
        contacts = getContacts();
        fileManager = new FileManager();
    }

    private void executeTest() {
        System.out.println("TESTING THE CREATION OF THE THREE CONTACTS...");
        createContacts();
        System.out.println("RETRIEVING THE THREE CONTACTS...");
        retrieveContacts();
        System.out.println("TESTING THE CREATION OF AN ALREADY EXISTING CONTACT");
        createExistingContact();
        System.out.println("TRYING TO RECOVER A NON-EXISTING CONTACT");
        retrieveNonExistingContact();
    }

    public void createContacts() {
        for (Contact contact : contacts) {
            createContact(contact);
        }
    }

    public void retrieveContacts() {
        for (Contact contact : contacts) {
            retrieveContact(contact.getName());
        }
    }

    public void createExistingContact() {
        createContact(contacts[0]);
    }

    public void retrieveNonExistingContact() {
        retrieveContact("Foo");
    }

    public void retrieveContact(String contactName) {
        try {
            Contact contact = fileManager.retrieve(contactName);
            System.out.println("Retrieved contact:\n"+ contact);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    private void createContact(Contact contact) {
        try {
            fileManager.insert(contact);
            System.out.println("Created contact:\n"+ contact);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    private Contact[] getContacts() {
        Contact contact1 = new Contact("Daniele","01234560","Guitars Street 1");
        Contact contact2 = new Contact("Giovanni","0565432190","Sciences Square 2");
        Contact contact3 = new Contact("Ligeia","07899921","Secrets Avenue 3");
        Contact[] contacts = {
            contact1, contact2, contact3
        } ;
        return contacts;
    }

    public static void main(String args[]) {
        Exercise20H exercise20H = new Exercise20H();
        exercise20H.executeTest();
    }
}