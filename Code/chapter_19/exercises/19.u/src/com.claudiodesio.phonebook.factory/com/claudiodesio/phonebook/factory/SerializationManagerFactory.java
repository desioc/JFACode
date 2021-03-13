package com.claudiodesio.phonebook.factory;

import com.claudiodesio.phonebook.spi.SerializationManager;
import com.claudiodesio.phonebook.data.Contact;
import java.util.Iterator;
import java.util.ServiceLoader;

public class SerializationManagerFactory {
    public static SerializationManager<Contact> getSerializationManager(String className){
        ServiceLoader<SerializationManager> serviceLoader = ServiceLoader.load(com.claudiodesio.phonebook.spi.SerializationManager.class);
        for (SerializationManager serializationManager : serviceLoader) {
            if (serializationManager.getClass().getSimpleName().equals(className)) {
                return serializationManager;
            }
        }
        throw new IllegalArgumentException("No serialization manager found for class = " + className);
    }
}