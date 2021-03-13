package com.claudiodesio.authentication;
import java.util.Scanner;

public class Authentication {

    private static final User[] users = {
        new User("Daniele", "dansap", "music"),
        new User("Giovanni", "giobat", "science"),
        new User("Ligeia", "ligder", "art")
    };

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Type  username.");
            String username = scanner.nextLine();
            User user = verifyUsername(username);
            if (user == null) {
                System.out.println("User not found!");
                continue;
            }
            System.out.println("Type password");
            String password = scanner.nextLine();
            if (password != null && password.equals(user.getPassword())) {
                System.out.println("Hello " + user.getName());
                break;
            } else {
                System.out.println("Authentication failed");
            }
        }
    }

    private static User verifyUsername(String username) {
        if (username != null) {
            for (User user : users) {
                if (username.equals(user.getUsername())) {
                    return user;
                }
            }
        }
        return null;
    }
}