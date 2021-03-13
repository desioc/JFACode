public class Contact {
    
    public String name;

    public String address;

    public String phoneNumber;
    
    public Contact (String nam, String num){
        name = nam;
        phoneNumber = num;
    }
    
    public Contact (String nam, String add, String num){
        name = nam;
        address = add;
        phoneNumber = num;
    }
}