package com.claudiodesio.frontoffice.data;

public class FrontOffice {

    private final Printer printer;
    private static FrontOffice instance;

    public synchronized static FrontOffice getInstance() {
        if (instance == null) {
            instance = new FrontOffice();
        }
        return instance;
    }

    private FrontOffice() {
        printer = Printer.getInstance();
    }

    public synchronized void handleRequest(Applicant applicant) {
        System.out.println("Hello " + applicant);
        System.out.println("Employee says: \"Please, fill in the form "
                + applicant + "\"");
        fillInModule(applicant);
        printer.print(applicant);
        System.out.println(applicant + " says: \"Thanks to you!\"");
    }

    private synchronized void fillInModule(Applicant applicant) {
        System.out.println(applicant + " says: \"OK, I will fill it but...\"");
        final int waiting = TimeUtils.getRandomNumber();
        try {
            System.out.println("...I need " + waiting + " minutes...");
            wait(waiting * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(applicant + " says: \"...the module is completed!\"");
    }
}