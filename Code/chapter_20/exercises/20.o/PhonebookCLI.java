package phonebook.presentation;

import phonebook.data.*;
import phonebook.exceptions.*;
import phonebook.integration.*;
import java.util.*;
import java.io.*;

public class PhonebookCLI {
    private Scanner scanner;
    private PhonebookController controller;
    private static final String INSERT ="/i";
    private static final String SHOW_CONTACT ="/v";
    private static final String END ="/t";

    public PhonebookCLI() {
        scanner = new Scanner(System.in);
        controller = new PhonebookController();
    }

    public void start() {
        try {
            controller.start();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void showContacts(List<Contact> contacts) {
        try {
            int numberOfContacts = contacts.size();
            if (numberOfContacts == 0) {
                System.out.println("No contact found");
            } else {
                System.out.println("Contacts list in the phonebook:");
                for (Contact contact : contacts) {
                    System.out.println(contact.getName());
                }
                System.out.printf("Type '%s' followed by the name of a contact, to see the details\n", SHOW_CONTACT);
            }
            System.out.printf("Type '%s' to insert a new contact\n", INSERT);
            System.out.printf("Type '%s' to terminate the program\n", END);
            String command = scanner.nextLine();
            if (command.equals(INSERT)) {
                System.out.println("Insert contact method called");
            } else if (command.equals(END)) {
                System.out.println("Program terminated");
                System.exit(1);
            } else if (isValidCommandToShowAContact(contacts, command)) {
                System.out.printf("Show contact method called for %s\n", extractContactName(command));
            } else {
                throw new InvalidCommandException(command);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println(exc.getMessage());
        }
    }

    private boolean isValidCommandToShowAContact(List<Contact> contacts, String command) throws NonExistingContactException, InvalidCommandException {
        boolean result = false;
        if (command.startsWith(SHOW_CONTACT)) {
            for (Contact contact : contacts) {
                if (command.endsWith(contact.getName())) {
                    return true;
                }
            }
        } else {
            throw new InvalidCommandException(command);
        }
        throw new NonExistingContactException(String.format("Contact %s not found!", extractContactName(command)));
    }

    public String extractContactName(String command) {
        return command.substring(command.indexOf(" ")+1, command.length());
    }

    class PhonebookController {
        SerializationManager fileManager;
        public PhonebookController () {
            try {
                fileManager = SerializationManagerFactory.getSerializationManager();
            } catch (Exception exc) {
                exc.printStackTrace();
                System.exit(1);
            }
        }

        public void start() throws IOException {
            List<Contact> contacts = fileManager.getContacts();
            showContacts(contacts);
        }
    }
}