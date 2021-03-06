import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Base64NIO2Test {
    public static void main(String args[]) throws Exception {
        Path originalPath = Paths.get("Base64NIO2Test.java");
        Path encodedPath = Paths.get("Base64NIO2Test.java.base64");
        Base64.Encoder encoder = Base64.getMimeEncoder();
        try (OutputStream output = Files.newOutputStream(encodedPath)) {
            Files.copy(originalPath, encoder.wrap(output));
            System.out.println(String.format("File %s encoded!", encodedPath));
        }
        Path decodedPath = Paths.get("Base64NIO2Test.java.decoded");
        Base64.Decoder decoder = Base64.getMimeDecoder();
        try (InputStream input = Files.newInputStream(encodedPath)) {
            Files.deleteIfExists(decodedPath);
            Files.copy(decoder.wrap(input), decodedPath);
            System.out.println(String.format("File %s decoded!", decodedPath));
        }
    }
}