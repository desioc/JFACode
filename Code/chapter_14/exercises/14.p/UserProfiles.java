package com.claudiodesio.authentication;

import java.util.*;
import java.io.*;

public class UserProfiles {

    private static UserProfiles instance;

    private Properties properties;

    private UserProfiles() {
        properties = new Properties();
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static UserProfiles getInstance() {
        if (instance == null) {
            instance = new UserProfiles();
        }
        return instance;
    }  

    public void loadProperties() throws IOException {
        try (FileInputStream inputStream = 
          new FileInputStream("config.properties");) {
            properties.load(inputStream);
        }
    }

    public void addUser(String[] args) throws IOException {
        String role = args[0];
        String name= args[1];
        String username = args[2];
        String password = args[3];
        // If the role Administrator is not specified
        //a clerk will always be inserted
        User user = (role.equals("Administrator") ?
          new Administrator(name, username, password):
          new Clerk(name, username, password));
        String value = name +","+ role+","+ password;
        properties.setProperty(username, value);
        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            properties.store(fos,"Configuration File");
        }
        System.out.println("Added property: " + username + "=" + value);
    }
}