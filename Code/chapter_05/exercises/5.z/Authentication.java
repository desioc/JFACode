package com.claudiodesio.authentication;

import java.util.*;

public class Authentication {

    private static final User[] users = {
        new User("Daniele", "dansap", "music"),
        new User("Giovanni", "giobat", "science"),
        new User("Ligeia", "ligder", "arte")
    };

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Insert username.");
            String username = scanner.nextLine();
            User user = verififyUsername(username);
            if (user == null) {
                System.out.println("User not found!");
                continue;
            }
            System.out.println("Insert password");
            String password = scanner.nextLine();
            if (password != null && password.equals(user.password)) {
                System.out.println("Welcome " + user.name);
                break;
            } else {
                System.out.println("Authentication failed");
            }
        }
    }

    private static User verifyUsername(String username) {
        if (username != null) {
            for (User user : users) {
                if (username.equals(user.username)) {
                    return user;
                }
            }
        }
        return null;
    }
}