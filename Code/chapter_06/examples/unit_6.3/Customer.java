public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    
    public Customer (String name, String address) {
        this(name,address,"unknown");
    }
    
    public Customer(String name, String address, String phoneNumber) {
        this.setName(name);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    // . . .
}