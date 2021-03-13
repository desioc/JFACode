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

    public void printDetails() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println();
    }
}