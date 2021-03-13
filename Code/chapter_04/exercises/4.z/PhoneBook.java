public class PhoneBook {
    public Contact [] contacts;
    public PhoneBook () {
        contacts = new Contact[]{new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313"),
                        new Contact("Stevie Wonder", "10, Music Avenue", "1010101010"),
                        new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square", "1111111111")};

    }

    public Contact[] searchContactsByName(String name) {
        Contact []foundContacts = new Contact[contacts.length];
        for (int i = 0, j = 0;  i < foundContacts.length; i++) {
            if (contacts[i].name.toUpperCase().contains(name.toUpperCase())) {
                foundContacts[j] = contacts[i];
                j++;
            }
        }
        return foundContacts;
    }
}