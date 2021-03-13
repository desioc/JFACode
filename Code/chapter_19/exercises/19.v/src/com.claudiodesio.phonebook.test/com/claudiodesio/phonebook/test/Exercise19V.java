package com.claudiodesio.phonebook.test;

import java.util.function.*;
import com.claudiodesio.phonebook.spi.SerializationManager;
import com.claudiodesio.phonebook.factory.SerializationManagerFactory;
import com.claudiodesio.phonebook.data.Contact;
import com.claudiodesio.phonebook.util.*;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Exercise19V {
    
    private SerializationManager<Contact> fileManager;

    private Contact[] contacts;

    public Exercise19V(String className) {
        contacts = getContacts();
        fileManager = SerializationManagerFactory.getSerializationManager(className);
    }
    
   public SerializationManager<Contact> getSerializationManager(String className){
        ServiceLoader<SerializationManager> serviceLoader = ServiceLoader.load(com.claudiodesio.phonebook.spi.SerializationManager.class);
        for (SerializationManager<Contact> serializationManager : serviceLoader) {
            if (serializationManager.getClass().getSimpleName().equals(className)) {
                return serializationManager;
            }
        }
        throw new IllegalArgumentException("No serialization manager found for class =" + className);
    }

    private void executeTest() {
        System.out.println("TESTING THE CREATION OF THE THREE CONTACTS");
        createContacts();
        System.out.println("RETRIEVING THE THREE CONTACTS");
        retrieveContacts();
        System.out.println("TESTIING THE CREATION OF A CONTACT ALREADY EXISTING");
        createExistingContact();
        System.out.println("TRYING TO RETRIEVE A CONTACT");
        retrieveNonExistentContact();
        System.out.println("UPDATING AN EXISTING CONTACT");
        updateExistingContact();
        System.out.println("REMOVING AN EXISTING CONTACT");
        removeExistingContact();
        System.out.println("UPDATING AN EXISTING CONTACT");
        updateNonExistentContact();
        System.out.println("REMOVING A NON-EXISTENT CONTACT");
        removeNonExistentContact();
    }

    public void createExistingContact() {
        execute(()->fileManager.insert(contacts[0]));
    }

    public void updateExistingContact() {        
        execute(()->fileManager.update(new Contact("Daniele","Mics Street 1","07890")));
    }
    
    public void removeExistingContact() {
        execute(()->fileManager.remove(contacts[2].getName()));
    }

    public void updateNonExistentContact() {
        execute(()->fileManager.update(new Contact("Foo","Mics Street 1","07890")));
    }
    
    public void removeNonExistentContact() {
        execute(()->fileManager.remove("Ligeia"));
    }

    public void retrieveNonExistentContact() {
        execute(()->fileManager.retrieve("Foo"));
    }

    public void createContacts() {
        for (Contact contact : contacts) {
            System.out.println("Creating contact:\n"+ contact);
            createContact(contact);
        }
    }

    public void retrieveContacts() {
        for (Contact contact : contacts) {
            System.out.println("Retrieving contact: "+ contact.getName());
            retrieveContact(contact.getName());
        }
    }

    public void retrieveContact(String nameContact) {
        execute(()->fileManager.retrieve(nameContact));
    }

    private void createContact(Contact contact) {
        execute(()->fileManager.insert(contact));
    }

    private Contact[] getContacts() {
        Contact contact1 = new Contact("Daniele","Guitars Street 1","01234560");
        Contact contact2 = new Contact("Giovanni","Sciences Avenue 2","0565432190");
        Contact contact3 = new Contact("Ligeia","Secrets Place 3","07899921");
        Contact[] contacts = {
            contact1, contact2, contact3
        } ;
        return contacts;
    }

    public <O> O execute(Retriever<O> retriever) {
        O output = null;
        try {
            output = retriever.execute();
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return output;
    }
    
    public void execute(Executor executor) {
        try {
            executor.execute();
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String args[]) {
        Exercise19V exercise19V = new Exercise19V(args[0]);
        exercise19V.executeTest();
    }
}