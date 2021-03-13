import java.io.*;
import java.util.*;

public class Base64Test {
    private static final String FILE ="person.base64";
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        //ENCODING
        Base64.Encoder encoder = Base64.getMimeEncoder();
        Person p = new Person ("Claudio","De Sio Cesari","xxx");
        try (FileOutputStream fos = new FileOutputStream (new File(FILE));
        OutputStream os = encoder.wrap(fos);
        ObjectOutputStream oos = new ObjectOutputStream (os);) {
            oos.writeObject (p);
            System.out.println("Object serialized: "+ p);
        }
        //DECODING
        Base64.Decoder decoder = Base64.getMimeDecoder();
        try (FileInputStream fis = new FileInputStream (new File(FILE));
        InputStream os = decoder.wrap(fis);
        ObjectInputStream ois = new ObjectInputStream(os);) {
            Person personDecoded = (Person)ois.readObject ();
            System.out.println("Object serialized: "+ personDecoded);
        }
    }
}