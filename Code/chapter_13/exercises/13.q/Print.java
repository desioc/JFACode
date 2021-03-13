package com.claudiodesio.authentication;

public class Print {

    public static void requestUsername() {
        printMessage("Type username.");
    }

    public static void requestPassword() {
        printMessage("Type password.");
    }

    public static void sayHello(String name) {
        printMessage("Hello " + name);
    }

    public static void usernameNotFound() {
        printMessage("User not found!");
    }

    public static void authenticationFailed() {
        printMessage("Authentication failed");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}