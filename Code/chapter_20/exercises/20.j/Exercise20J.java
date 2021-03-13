package phonebook.test;

import phonebook.exceptions.*;
import phonebook.integration.*;
import phonebook.data.*;

public class Exercise20J {
    private SerializationManager<Contact> fileManager;

    private Contact[] contacts;

    private void executeTest() {
        System.out.println("TESTING THE CREATION OF THE THREE CONTACTS...");
        createContacts();
        System.out.println("RETRIEVING THE THREE CONTACTS...");
        retrieveContacts();
        System.out.println("TESTING THE CREATION OF AN ALREADY EXISTING CONTACT");
        createExistingContact();
        System.out.println("TRYING TO RECOVER A NON-EXISTING CONTACT");
        retrieveNonExistingContact();
        System.out.println("UPDATING AN EXISTING CONTACT");
        updateExistingContact();
        System.out.println("REMOVING AN EXISTING CONTACT");
        removeExistingContact();
        System.out.println("UPDATING A NON-EXISTING CONTACT");
        updateNonExistingContact();
        System.out.println("REMOVING A NON-EXISTING CONTACT");
        removeNonExistingContact();
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

    public void updateExistingContact() {
        try {
            Contact contact = new Contact("Daniele","Mics Street 1","07890");
            fileManager.update(contact);
            System.out.println("Contact "+ contact.getName() +" updated!");
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    public void removeExistingContact() {
        try {
            fileManager.remove(contacts[2].getName());
            System.out.println("Contact "+ contacts[2].getName() +" removed!");
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void updateNonExistingContact() {
        try {
            Contact contact = new Contact("Bar","Mics Street 1","07890");
            fileManager.update(contact);
            System.out.println("Contact "+ contact.getName() +" updated!");
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    public void removeNonExistingContact() {
        try {
            String name ="Ligeia";
            fileManager.remove(name);
            System.out.println("Contact "+ name +" removed!");
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
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
        Exercise20J exercise20J = new Exercise20J();
        exercise20J.executeTest();
    }
}