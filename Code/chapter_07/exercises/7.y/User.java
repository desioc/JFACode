package phonebook.business;
import phonebook.data.*;

public class User {
     public Contact[] searchContactsByName(String name) {
        Contact[]contacts = PhoneBook.getInstance().getContacts();
        Contact []contactsFound = new Contact[contacts.length];
        for (int i = 0, j = 0;  i < contactsFound.length; i++) {
            if (contacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                contactsFound[j] = contacts[i];
                j++;
            }
        }
        return contactsFound;
    }

    public Special[] searchSpecialContactsByName(String name) {
        Special[]specialContacts = PhoneBook.getInstance().getSpecialContacts();
        Special []specialContactsFound = new Special[specialContacts.length];
        for (int i = 0, j = 0;  i < specialContactsFound.length; i++) {
            if (specialContacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                specialContactsFound[j] = specialContacts[i];
                j++;
            }
        }
        return specialContactsFound;
    }
}