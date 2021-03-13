package phonebook.integration;

import java.util.*;
import java.io.*;
import phonebook.exceptions.*;
import phonebook.util.*;
import phonebook.data.*;
import java.nio.file.*;
import java.util.stream.*;

public class FileManagerNIO2 implements SerializationManager<Contact> {
    @Override
    public void insert(Contact contact) throws DuplicateContactException, FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(contact.getName()));
        if (Files.exists(path)) {
            throw new DuplicateContactException(contact.getName() +": contact already existing!");
        }
        register(contact);
    }

    @Override
    public Contact retrieve(String name) throws NonExistingContactException {
        Contact contact = getContact(FileUtils.getFileName(name));
        if (contact == null) {
            throw new NonExistingContactException(name +": contact not found!");
        }
        return contact;
    }

    @Override
    public void update(Contact contact) throws NonExistingContactException, DuplicateContactException, FileNotFoundException, IOException {
        if (isExistingContact(contact.getName())) {
            register(contact);
        } else {
            throw new NonExistingContactException(contact.getName() +": contact not found!");
        }
    }

    @Override
    public void remove(String name) throws NonExistingContactException, DuplicateContactException, FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(name));
        if (Files.exists(path)) {
            Files.delete(path);
        } else {
            throw new NonExistingContactException(name +": contact not found!");
        }
    }

    @Override
    public List<Contact> getContacts() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get("."))) {
            contacts = walk.map(p -> p.toString())
            .filter(f -> f.endsWith(".con")).map(f -> getContact(f)).collect(Collectors.toList());
        }
        return contacts;
    }

    private void register(Contact contact) throws  FileNotFoundException, IOException {
        Path path = Paths.get(FileUtils.getFileName(contact.getName()));
        Files.write(path, getBytesFromObject(contact));
    }

    private byte[] getBytesFromObject(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    private Object getObjectFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
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
        Path path = Paths.get(name);
        byte[] bytes = null;
        Contact contact = null;
        try {
            bytes = Files.readAllBytes(path);
            contact = (Contact)getObjectFromBytes(bytes);
        }
        catch (Exception exc) {
            return null;
        }
        return contact;
    }
}