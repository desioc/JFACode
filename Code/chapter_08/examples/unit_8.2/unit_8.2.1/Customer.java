public class Customer {
    private String name;
    private String address;
    private int phoneNumber;
    public Customer() {
        // constructor explicitely inserted (this is not the default contructor)
    }
    public Customer(String name) {
        this.name = name;
    }
    public Customer(String name, String address) {
        this(name);
        this.address = address;
    }
    public Customer(String name, String address, int phoneNumber) {
        this(name, address);
        this.phoneNumber = phoneNumber;
    }
//    . . .
}