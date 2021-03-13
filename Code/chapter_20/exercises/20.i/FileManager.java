package phonebook.integration;

import java.util.*;
import java.io.*;
import phonebook.exceptions.*;
import phonebook.util.*;
import phonebook.data.*;

public class FileManager {
    
    public void insert(Contact contact) throws DuplicateContactException, FileNotFoundException, IOException {
        Contact existingContact = getContact(contact.getName());
        if (existingContact != null) {
            throw new DuplicateContactException(contact.getName() +": contact already existing!");
        }
        store(contact);
    }
    
    public Contact retrieve(String name) throws NonExistingContactException {
        Contact contact = getContact(name);
        if (contact == null) {
            throw new NonExistingContactException(name +": contact not found!");
        }
        return contact;
    }

    public void update(Contact contact) throws NonExistingContactException, DuplicateContactException, FileNotFoundException, IOException {
        if (isExistingContact(contact.getName())) {
            store(contact);
        } else {
            throw new NonExistingContactException(contact.getName() +": contact not found!");
        }
    }

    public void remove(String name) throws NonExistingContactException, DuplicateContactException, FileNotFoundException, IOException {
        File file = new File(FileUtils.getFileName(name));
        if (!file.delete()) {
            throw new NonExistingContactException(name +": contact not found!");
        }
    }

    private void store(Contact contact) throws  FileNotFoundException, IOException {
        try (FileOutputStream fos =
        new FileOutputStream (new File(FileUtils.getFileName(contact.getName())));
        ObjectOutputStream s = new ObjectOutputStream (fos);) {
            s.writeObject (contact);
        }
    }

    private boolean isExistingContact(String name) {
        File file = new File(FileUtils.getFileName(name));
        return file.exists();
    }

    private Contact getContact(String name) {
        try (FileInputStream fis = new FileInputStream (new File(FileUtils.getFileName(name)));
                ObjectInputStream ois = new ObjectInputStream (fis);) {
            Contact contact = (Contact)ois.readObject();
            return contact;
        } catch (Exception exc) {
            return null;
        }
    }
}