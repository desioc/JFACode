package phonebook.integration;

import phonebook.data.Contact;
import java.util.Properties;
import java.io.*;

public class SerializationManagerFactory {
    private static final String PACKAGE ="phonebook.integration.";
    private static final String SERIALIZATION_METHOD ="phonebook.ser";
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static SerializationManager<Contact> getSerializationManager() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        String className = properties.getProperty(SERIALIZATION_METHOD);
        System.out.println("Loading the " + className + " class");
        Class<?> classObject = Class.forName(PACKAGE + className);
        return (SerializationManager<Contact>)classObject.newInstance();
    }

    private static void loadProperties() throws IOException {
        try (FileInputStream inputStream = new FileInputStream("config.properties");) {
            properties.load(inputStream);
        }
    }
}