package com.claudiodesio.phonebook.spi;

import com.claudiodesio.phonebook.data.Data;

import java.io.*;

import java.util.*;

public interface SerializationManager<T extends Data> {
   
    void insert(T data) throws IOException;
    
    T retrieve(String id) throws IOException, ClassNotFoundException;
    
    void update(T data) throws IOException;
    
    void remove(String id) throws IOException;
}