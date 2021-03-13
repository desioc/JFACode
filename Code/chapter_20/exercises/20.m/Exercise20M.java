package phonebook.test;

import phonebook.exceptions.*;
import phonebook.integration.*;
import phonebook.data.*;
import phonebook.util.*;

public class Exercise20M {
    
    private SerializationManager<Contact> fileManager;

    private Contact[] contacts;

    Exercise20M() {
        contacts = getContacts();
        try {
            fileManager = SerializationManagerFactory.getSerializationManager();
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }
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
        System.out.println("UPDATING AN EXISTING CONTACT");
        updateExistingContact();
        System.out.println("REMOVING AN EXISTING CONTACT");
        removeExistingContact();
        System.out.println("UPDATING A NON-EXISTING CONTACT");
        updateNonExistingContact();
        System.out.println("REMOVING A NON-EXISTING CONTACT");
        removeNonExistingContact();
    } 
      
     public void retrieveContacts() {
        for (Contact contact : contacts) {
            retrieveContact(contact.getName());
        }
    }
    
    public void createContacts() {
        for (Contact contact : contacts) {
            createContact(contact);
        }
    }
    
    public void createExistingContact() {
        createContact(contacts[0]);
    }

    public void updateExistingContact() { 
        Contact contact = new Contact("Daniele","07890", "Mics Street 1");
        String message ="Contact "+ contact.getName() +" updated!\n"+ contact;
        execute(()->fileManager.update(contact), message);
    }
       
    public void removeExistingContact() {
        String name = contacts[2].getName();
        String message ="Contact "+ name +" removed!";
        execute(()->fileManager.remove(name), message);
    }

    public void updateNonExistingContact() {
        Contact contact = new Contact("Bar","07890", "Mics Street 1");
        String message ="Contact "+ contact.getName() +" updated!";
        execute(()->fileManager.update(contact), message);
    }

    public void removeNonExistingContact() {
        String name ="Ligeia";
        String message ="Contact "+ name +" removed!";
        execute(()->fileManager.remove(name), message);
    }

    public void retrieveNonExistingContact() {
        retrieveContact("Foo");
    }
    
    public void retrieveContact(String contactName) {
        execute(()->fileManager.retrieve(contactName));
    }

    private void createContact(Contact contact) {
        String message = "Contact "+ contact.getName() +" created!\n"+ contact;
        execute(()->fileManager.insert(contact), message);
    }  

    public <O> O execute(Retriever<O> retriever) {
        O output = null;
        try {
            output = retriever.execute();
            System.out.println("Retrieved contact:\n"+ output);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return output;
    }

    public void execute(Executor executor, String message) {
        try {
            executor.execute();
            System.out.println(message);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
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
        Exercise20M exercise20M = new Exercise20M();
        exercise20M.executeTest();
    }
}