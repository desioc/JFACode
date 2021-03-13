import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;

public class FilesBufferedWriterTest {
    public static void main(String args[]) {
        Charset charset = Charset.forName("UTF-8");
        String fileContent = "Ciao";
        //Change as you want
        Path path = Paths.get("C:\\Users\\user\\Desktop\\test.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            writer.write(fileContent, 0, fileContent.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}