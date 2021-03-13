public class Contact {
    protected static final String UNKNOWN ="unknown";
    private String name;
    private String phoneNumber;
    private String address;

    public Contact(String name, String phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(UNKNOWN);
    }

    public Contact(String name, String phoneNumber, String address) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(phoneNumber);
        System.out.println();
    }
}