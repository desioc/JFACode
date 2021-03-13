package com.claudiodesio.authentication;

import java.io.*;

public class Exercise14P {
    
    public static void main(String args[]) throws IOException {
        System.out.println("args");
        if (args.length != 4) {
            System.out.println("Specify role, name, username, password");
            System.exit(1);
        }
        UserProfiles.getInstance().addUser(args);
    }
}