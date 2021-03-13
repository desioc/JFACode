public class Customer extends Person {
    private String address, phoneNumber;
    public String toString(){
        return super.toString()+ "\n"+ 
        address + "\nTel:" + phoneNumber;
    }
    //accessor and mutator methods (set and get) omitted
}