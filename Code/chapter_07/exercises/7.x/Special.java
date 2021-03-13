public class Special extends Contact {

    private String ringtone;

    public Special(String name, String phoneNumber, String address, 
            String ringtone) {
        super(name, phoneNumber, address);
        setRingtone(ringtone);
    }
    
    public String getRingtone() {
        return ringtone;
    }

    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    public void printDetails() {
        System.out.println(getName());
        System.out.println(getAddress());
        System.out.println(getPhoneNumber());
        System.out.println(getRingtone());
        System.out.println();
    }    
}