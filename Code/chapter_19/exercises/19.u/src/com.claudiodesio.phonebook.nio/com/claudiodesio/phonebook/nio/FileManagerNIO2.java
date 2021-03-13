package com.claudiodesio.phonebook.nio;

import com.claudiodesio.phonebook.spi.SerializationManager;
import com.claudiodesio.phonebook.data.Contact;
import com.claudiodesio.phonebook.exceptions.*;
import com.claudiodesio.phonebook.util.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class FileManagerNIO2 implements SerializationManager<Contact> {
    
    @Override
    public void insert(Contact contact) throws DuplicateContactException, FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(contact.getName()));
        if (Files.exists(path)) {
            throw new DuplicateContactException(contact.getName() +": contact already exists!");
        }
        store(contact);
    }

    @Override
    public Contact retrieve(String name) throws ContactNotFoundException, DuplicateContactException {
        Contact contact = getContact(name);
        if (contact == null) {
            throw new ContactNotFoundException(name +": contact not found!");
        }
        return contact;
    }

    @Override
    public void update(Contact contact) throws ContactNotFoundException, DuplicateContactException, FileNotFoundException, IOException {
        if (isExistingContact(contact.getName())) {
            store(contact);
        } else {
            throw new ContactNotFoundException(contact.getName() +": contact not found!");
        }
    }

    @Override
    public void remove(String name) throws ContactNotFoundException, DuplicateContactException, FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(name));
        if (Files.exists(path)) {
            Files.delete(path);
            System.out.println("Contact "+ name +" deleted!");        
        } else {
            throw new ContactNotFoundException(name +": contact not found!");
        }
    }

    private void store(Contact contact) throws  FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(contact.getName()));
        Files.write(path, getBytesFromObject(contact));
        System.out.println("Contact stored:\n"+ contact);
    }

    private byte[] getBytesFromObject(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    private Object getObjectFromByte(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    private boolean isExistingContact(String name) {
        Path path = Paths.get(FileUtils.getFileName(name));
        return Files.exists(path);
    }

    private Contact getContact(String name) {
        Path path = Paths.get(FileUtils.getFileName(name));
        byte[] bytes = null;
        Contact contact = null;
        try {
            bytes = Files.readAllBytes(path);
            contact = (Contact)getObjectFromByte(bytes);
            System.out.println("Contact retrieved:\n"+ contact);
        }
        catch (Exception exc) {
            return null;
        }
        return contact;
    }
}