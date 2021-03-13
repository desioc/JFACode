package phonebook.test ;
import phonebook.data.*;
import phonebook.integration.*;

public class Exercise20G {
    private FileManager fileManager;
    private Contact[] contacts;

    Exercise20G() {
        contacts = getContacts();
        fileManager = new FileManager();
    }

    private void executeTest() {
        System.out.println("TESTING THE CREATION OF THE THREE CONTACTS...");
        createContacts();
        System.out.println("RETRIEVING THE THREE CONTACTS...");
        retrieveContacts();
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
    
    public void retrieveContact(String contactName) {
        try {
            Contact contact = fileManager.retrieve(contactName);
            System.out.println("Retrieved contact:\n" + contact);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void createContact(Contact contact) {
        try {
            fileManager.insert(contact);
            System.out.println("Created contact:\n"+ contact);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private Contact[] getContacts() {
        Contact contact1 = new Contact("Daniele", "01234560", "Guitars Street 1");
        Contact contact2 = new Contact("Giovanni", "0565432190", "Sciences Square 2");
        Contact contact3 = new Contact("Ligeia", "07899921", "Secrets Avenue 3");
        Contact[] contacts = {
            contact1, contact2, contact3
        } ;
        return contacts;
    }

    public static void main(String args[]) {
        Exercise20G exercise20G = new Exercise20G();
        exercise20G.executeTest();
    }
}