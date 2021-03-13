package phonebook.integration;

import java.util.*;
import java.io.*;
import phonebook.exceptions.*;
import phonebook.util.*;
import phonebook.data.*;

public interface SerializationManager<T extends Data> {
   
    void insert(T data) throws IOException;
    
    T retrieve(String id) throws IOException, ClassNotFoundException;
    
    void update(T data) throws IOException;
    
    void remove(String id) throws IOException;
}