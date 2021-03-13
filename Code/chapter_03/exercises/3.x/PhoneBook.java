public class PhoneBook {
    public Contact [] contacts;
    public PhoneBook () {
        contacts = new Contact[]{new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313"),
                        new Contact("Stevie Wonder", "10, Music Avenue", "1010101010"),
                        new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square", "1111111111")};
        /*contacts = new Contact[3];
        contacts[0] = new Contact("Claudio De Sio Cesari", "13, Java Street", "131313131313");
        contacts[1] = new Contact("Stevie Wonder", "10, Music Avenue", "1010101010");
        contacts[2] = new Contact("Gennaro Capuozzo", "1, Four Days of Naples Square", "1111111111");*/
    }
}