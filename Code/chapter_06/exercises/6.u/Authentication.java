package com.claudiodesio.authentication;

import java.util.Scanner;

public class Authentication {

    public void login() {
        boolean authorized = false;
        Scanner scanner = new Scanner(System.in);
        do {
            Print.requestUsername();
            String username = scanner.nextLine();
            User user = findUser(username);
            if (user != null) {
                Print.requestPassword();
                String password = scanner.nextLine();
                if (verifyPassword(user, password)) {
                    Print.sayHello(user.getName());
                    authorized = true;
                } else {
                    Print.authenticationFailed();
                }
            } else {
                Print.usernameNotFound();
            }
        } while (!authorized);
    }

    private User findUser(String username) {
        User[] users = UserProfiles.getInstance().getUsers();
        if (username != null) {
            for (User user : users) {
                if (username.equals(user.getUsername())) {
                    return user;
                }
            }
        }
        return null;
    }

//    private boolean verifyUsername(String username) {
//        User[] users = UserProfiles.getInstance().getUsers();
//        boolean found = false;
//        User user = findUser(username);
//        if (user != null && username.equals(user.getUsername())) {
//            found = true;
//        }
//        return found;
//    }
    private boolean verifyPassword(User user, String password) {
        boolean found = false;
        if (password != null) {
            if (password.equals(user.getPassword())) {
                found = true;
            }
        }
        return found;
    }

    public static void main(String args[]) {
        Authentication authentication = new Authentication();
        authentication.login();
    }
}