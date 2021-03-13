package phonebook.data;

public class PhoneBook implements Data {
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

    public Contact[] getContacts() {
        return contacts;
    }
    
    public Special[] getSpecialContacts() {
        return specialContacts;
    }
}