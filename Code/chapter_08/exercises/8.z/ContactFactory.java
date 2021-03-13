package phonebook.data;

import phonebook.data.Special;
import phonebook.data.Contact;

public class ContactFactory {
    
    public static Contact getContact(String name, String phoneNumber,
            String address) {
        return new Contact(name, phoneNumber, address);
    }

    public static Special getContact(String name, String phoneNumber,
            String address, String ringtone) {
        return new Special(name, phoneNumber, address, ringtone);
    }
}