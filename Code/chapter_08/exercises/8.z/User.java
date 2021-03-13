package phonebook.business;
import phonebook.data.*;

public class User {
    private PhoneBook phoneBook;
    
    public User() {
        phoneBook = PhoneBook.getInstance();
    }

    public Contact[] searchContactsByName(String name) {
        Contact[]contacts = phoneBook.getContacts();
        Contact[]contactsFound = new Contact[contacts.length];
        for (int i = 0, j = 0;  i < contacts.length; i++) {
            if (contacts[i] == null) {
                break;
            }
            if (contacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                contactsFound[j] = contacts[i];
                j++;
            }
        }
        return contactsFound;
    }

    public Special[] searchSpecialContactsByName(String name) {
        Special[]specialContacts = phoneBook.getSpecialContacts();
        Special[]specialContactsFound = new Special[specialContacts.length];
        for (int i = 0, j = 0;  i < specialContacts.length; i++) {
            if (specialContacts[i] == null) {
                break;
            }
            if (specialContacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                specialContactsFound[j] = specialContacts[i];
                j++;
            }
        }
        return specialContactsFound;
    }

    public Contact[] searchOrdinaryContactsByName(String name) {
        Contact[]ordinaryContacts = phoneBook.getOrdinaryContacts();
        Contact[]ordinaryContactsFound = new Contact[ordinaryContacts.length];
        for (int i = 0, j = 0;  i < ordinaryContacts.length; i++) {
            if (ordinaryContacts[i] == null) {
                break;
            }
            if (ordinaryContacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                System.out.println(ordinaryContacts[i]);
                ordinaryContactsFound[j] = ordinaryContacts[i];
                j++;
            }
        }
        return ordinaryContactsFound;
    }
    
    public void add(Contact contactToAdd) {
        Contact[] contacts = phoneBook.getContacts();
        for (int i = 0; i < contacts.length; ++i) {
            if (contacts[i] == null) {
                contacts[i] = contactToAdd;
                break;
            }
        }
    }

}