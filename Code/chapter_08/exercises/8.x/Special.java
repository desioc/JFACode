package phonebook.data;

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

    @Override
    public String toString() {
        return  super.toString() + "\nRingtone="+ ringtone;
    }
 
}