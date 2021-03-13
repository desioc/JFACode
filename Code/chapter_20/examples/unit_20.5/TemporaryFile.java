import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class TemporaryFile {
    public static void main(String args[]) {
        try {
            Path temporaryFile = Files.createTempFile(null, ".tmp");
            System.out.format("Temporary file created: " +
            temporaryFile);
        } catch (IOException exc) {
            System.err.println("IOException: " + exc);
        }
    }
}