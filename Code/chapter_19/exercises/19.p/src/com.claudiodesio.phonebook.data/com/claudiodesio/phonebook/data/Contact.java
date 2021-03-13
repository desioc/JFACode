package com.claudiodesio.phonebook.data;

import java.io.Serializable;

public class Contact implements Data {  
    
    private static final long serialVersionUID = 8942402240056525661L;
    
    private String name;

    private String address;

    private String phoneNumber;

    public Contact (String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return "Name:\t" + name + "\nAddress:\t" + address + "\nPhone:\t" + phoneNumber;
    }
}