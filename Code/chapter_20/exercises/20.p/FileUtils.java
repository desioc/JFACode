package phonebook.util;

public class FileUtils {
    
    public static final String SUFFIX =".con";

    public static String getFileName(String name) {
        return name + SUFFIX;
    }
}