package phonebook.integration;
import java.util.*;
import java.io.*;
import phonebook.util.*;
import phonebook.data.*;

public class FileManager {

    public void insert(Contact contact) throws IOException {
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
    }
}