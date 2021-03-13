package com.claudiodesio.frontoffice.data;

public class Printer {

    private static Printer instance;

    private Printer() {
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public synchronized void print(Applicant applicant) {
        System.out.println("Employee says: printing passport for " + applicant
                + " in progress...");
        try {
            wait(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Employee says: Print completed! " + applicant
                + " thanks and goodbye!");
    }
}