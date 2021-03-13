package com.claudiodesio.phonebook.io;

import com.claudiodesio.phonebook.spi.SerializationManager;
import com.claudiodesio.phonebook.data.Contact;
import com.claudiodesio.phonebook.exceptions.*;
import com.claudiodesio.phonebook.util.*;
import java.util.*;
import java.io.*;

public class FileManager implements SerializationManager<Contact> {
    
    @Override
    public void insert(Contact contact) throws DuplicateContactException, FileNotFoundException, IOException {
        Contact duplicateContact = getContact(contact.getName());
        if (duplicateContact != null) {
            throw new DuplicateContactException(contact.getName() +": contact already exists!");
        }
        store( contact);
    }

    @Override
    public Contact retrieve(String name) throws ContactNotFoundException, DuplicateContactException {
        Contact contact = getContact(name);
        if (contact == null) {
            throw new ContactNotFoundException(name + ": contact not found!");
        }
        return contact;
    }

    @Override
    public void update(Contact contact) throws ContactNotFoundException, DuplicateContactException, FileNotFoundException, IOException {
        if (isContactExisting(contact.getName())) {
            store(contact);
        } else {
            throw new ContactNotFoundException(contact.getName() +": contact not found!");
        }
    }

    @Override
    public void remove(String name) throws ContactNotFoundException, DuplicateContactException, FileNotFoundException, IOException {
        File file = new File(FileUtils.getFileName(name));
        if (file.delete()) {
            System.out.println("Contact " + name + " deleted!");
        } else {
            throw new ContactNotFoundException(name +": contact not found!");
        }
    }

    private void store(Contact contact) throws  FileNotFoundException, IOException {
        try (FileOutputStream fos =
        new FileOutputStream (new File(FileUtils.getFileName(contact.getName())));
        ObjectOutputStream s = new ObjectOutputStream (fos);) {
            s.writeObject (contact);
            System.out.println("Contact stored:\n"+ contact);
        }
    }

    private boolean isContactExisting(String name) {
        File file = new File(FileUtils.getFileName(name));
        return file.exists();
    }

    private Contact getContact(String name) {
        try (FileInputStream fis = new FileInputStream (new File(FileUtils.getFileName(name)));
        ObjectInputStream ois = new ObjectInputStream (fis);) {
            Contact contact = (Contact)ois.readObject();
            System.out.println("Contact retrieved:\n"+ contact);
            return contact;
        } catch (Exception exc) {
            return null;
        }
    }
}