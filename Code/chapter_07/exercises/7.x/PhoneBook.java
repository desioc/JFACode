public class PhoneBook {
    private static PhoneBook instance;
    public Contact[] contacts;
    public Special[] specialContacts;

    private PhoneBook () {
         contacts = new Contact[]{new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313"),
                        new Contact("Stevie Wonder", "10, Music Avenue", "1010101010"),
                        new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square", "1111111111")
         };

        specialContacts = new Special[] {
            new Special("Mario Ruoppolo", "Neruda Street, 3", "333333", "The Postman"),
            new Special("Vincenzo Malinconico", "Courts Street, 8", "888888", "Tuca Tuca"),
            new Special("Logan Howlett", "Canada Square, 6", "66666", "Hurt")
        };
    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    public Contact[] searchContactsByName(String name) {
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
        Special []specialContactsFound = new Special[specialContacts.length];
        for (int i = 0, j = 0;  i < specialContactsFound.length; i++) {
            if (specialContacts[i].getName().toUpperCase().contains(name.toUpperCase())) {
                specialContactsFound[j] = specialContacts[i];
                j++;
            }
        }
        return specialContactsFound;
    }

    public Contact[] getContacts() {
        return contacts;
    }
    
    public Special[] getSpecialContacts() {
        return specialContacts;
    }
}