package com.claudiodesio.authentication;

import java.util.Scanner;

public class Authentication {

    public void login() {
        boolean authorized = false;
        Scanner scanner = new Scanner(System.in);
        do {
            Print.requestUsername();
            String username = scanner.nextLine();
            User user = UserProfiles.getInstance().getUser(username);
            if (user != null) {
                Print.requestPassword();
                String password = scanner.nextLine();
                if (checkPassword(user, password)) {
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

    private boolean checkPassword(User user, String password) {
        boolean found = false;
        if (password != null) {
            if (password.equals(user.getPassword())) {
                found = true;
            }
        }
        return found;
    }
}