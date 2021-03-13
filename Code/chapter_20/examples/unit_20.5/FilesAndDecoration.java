import static java.nio.file.StandardOpenOption.*;
import  java.nio.file.*;
import  java.io.*;

public class FilesAndDecoration {
    public static void main(String args[]) {
        Path file = Paths.get("C:\\Program Files\\EJE\\README.htm");
        String signature = "Created by Claudio...";
        byte data[] = signature.getBytes();

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(file,CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}