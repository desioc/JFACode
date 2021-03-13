import java.io.*;
import java.time.*;

public class Person implements java.io.Serializable {
    private static final long serialVersionUID = 8848963813726842888L;
    private String name;
    private String surname;
    private transient Thread t = new Thread();
    private transient /* static */ String secretCode;

    public Person(String name, String surname, String secretCode) {
        this.setName(name);
        this.setSurname(surname);
        this.setSecretCode(secretCode);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public String toString() {
        return"Name: "+ getName() + "\nSurname: "+ getSurname() + "\nSecret Code: "+ getSecretCode();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(Instant.now());
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        surname = "***********";
        System.out.println("Serialization time " + in.readObject());
    }
}