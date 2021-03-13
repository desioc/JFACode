import java.io.*;

public class DeSerializeObject {
    public static void main (String args[]) throws Exception {
        Person p = null;
        try (FileInputStream f = new FileInputStream (new File("person.ser"));
                ObjectInputStream s = new ObjectInputStream (f);) {
            p = (Person)s.readObject();
            System.out.println("Object deserialized!");
            System.out.println(p);
        }
    }
}