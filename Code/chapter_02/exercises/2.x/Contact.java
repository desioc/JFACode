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

    //usato dalla versione 2   
    public void printDetails() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println();
    }
}