package phonebook.data;

import phonebook.exceptions.*;

public class Contact extends Entity {
    protected static final String UNKNOWN ="unknown";
    private String name;
    private String phoneNumber;
    private String address;

    public Contact(String name, String phoneNumber)  throws EmptyNameException {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(UNKNOWN);
    }

    public Contact(String name, String phoneNumber, String address)  throws EmptyNameException {
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

    public void setName(String name) throws EmptyNameException {
        if (name == null || name.trim().length() == 0) {
            throw new EmptyNameException();
        }
        this.name = name;

    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return"Name:\t"+ name +"\nAddress:\t"+ address +"\nPhone:\t"+ phoneNumber;
    }
}