package phonebook.integration;

import java.util.*;
import java.io.*;
import phonebook.exceptions.*;
import phonebook.util.*;
import phonebook.data.*;

public class FileManager {
    public void insert(Contact contact) throws DuplicateContactException, FileNotFoundException, IOException {
        Contact existingContact = getContact(FileUtils.getFileName(contact.getName()));
        if (existingContact != null) {
            throw new DuplicateContactException(contact.getName()
            +": contact already existing!");
        }
        try (FileOutputStream fos = new FileOutputStream (
        new File(FileUtils.getFileName(contact.getName())));
        ObjectOutputStream s = new ObjectOutputStream (fos);) {
            s.writeObject (contact);
        }
    }

    public Contact retrieve(String name) throws NonExistingContactException {
        Contact contact = getContact(FileUtils.getFileName(name));
        if (contact == null) {
            throw new NonExistingContactException(name +": contact not found!");
        }
        return contact;
    }

    private Contact getContact(String name) {
        try (FileInputStream fis = new FileInputStream (new File(name));
        ObjectInputStream ois = new ObjectInputStream (fis);) {
            Contact contact = (Contact)ois.readObject();
            return contact;
        } catch (Exception exc) {
            return null;
        }
    } 

    /* public void insert(Contact contact) throws IOException {
        try (FileOutputStream fos =
        new FileOutputStream (new File(FileUtils.getFileName(contact.getName())));
        ObjectOutputStream s = new ObjectOutputStream (fos);) {
            s.writeObject (contact);
        }
    }

    public Contact retrieve(String name) throws IOException, ClassNotFoundException {
        Contact contact = null;
        try (FileInputStream fis = new FileInputStream (new File(name + FileUtils.SUFFIX));
        ObjectInputStream ois = new ObjectInputStream (fis);) {
            contact = (Contact)ois.readObject();
        }
        return contact;
    } */
}