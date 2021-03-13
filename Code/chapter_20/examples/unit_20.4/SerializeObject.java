import java.io.*;

public class SerializeObject {
    public static void main (String args[]) throws IOException {
        Person p = new Person ("Claudio", "De Sio Cesari", "xxx");
        try (FileOutputStream f = 
               new FileOutputStream (new File("person.ser"));
             ObjectOutputStream s = new ObjectOutputStream (f);) {
            s.writeObject (p);
            System.out.println("Object  serialized!");
        } 
    }
}