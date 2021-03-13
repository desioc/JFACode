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
    private static final String EXECUTE ="/e";
    private static final String BACK ="/b";
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
                int size = contacts.size();
                for (int i = 1; i <= size; ++i) {
                    System.out.println(i +"\t"+contacts.get(i-1).getName());
                }
                System.out.printf("Type '%s' followed by the name of a contact, to see the details\n", SHOW_CONTACT);
            }
            System.out.printf("Type '%s' to insert a new contact\n", INSERT);
            System.out.printf("Type '%s' to terminate the program\n", END);
            String command = scanner.nextLine();
            controller.handleShowContacts(command, contacts);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void insertContact() {
        try {
            String name = getContactData("name");
            String telephoneNumber = getContactData("telephone number");
            String address = getContactData("address");
            System.out.printf("Type '%s' to confirm the insertion\n",  EXECUTE);
            System.out.printf("Type '%s' to go back and show contacts\n", BACK);
            String command = scanner.nextLine();
            controller.handleInsertContact(command, name, telephoneNumber, address);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void showConfirmation(String message) {
        try {
            System.out.println("Operation Confirmed!");
            showMessage(message);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    private void showMessage(String message) throws IOException,  InvalidCommandException {
        System.out.println(message +"\n");
        System.out.printf("Type '%s' to go back and show contacts\n", BACK);
        System.out.printf("Type '%s' to terminate the program\n", END);
        String command = scanner.nextLine();
        controller.handleShowConfirmation(command);
    }

    private String getContactData(String data) {
        String message = String.format("Insert the %s of the contact:", data);
        return getUserInput(message);
    }

    private String getUserInput(String message) {
        System.out.printf(message);
        return scanner.nextLine();
    }

    class PhonebookController {
        SerializationManager<Contact> fileManager;
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


        public void handleShowContacts(String command, List<Contact> contacts) throws IOException {
            if (command.equals(INSERT)) {
                insertContact();
            } else if (command.equals(END)) {
                System.out.println("Program terminated");
                System.exit(1);
            } else if (isValidCommandToShowAContact(contacts, command)) {
                System.out.printf("Show contact method called for %s\n", extractContactName(command));
            } else {
                throw new InvalidCommandException(command);
            }
        }

        public void handleInsertContact(String command, String name,  String telephoneNumber, String address) throws IOException, EmptyNameException {
            if (command.equals(EXECUTE)) {
                Contact contact = new Contact(name, telephoneNumber, address);
                fileManager.insert(contact);
                showConfirmation("Contact inserted:\n"+ contact);
            } else if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
            } else {
                throw new InvalidCommandException(command);
            }
        }

        public void handleShowConfirmation(String command) throws IOException, InvalidCommandException {
            if (command.equals(END)) {
                System.out.println("Program terminated");
                System.exit(1);
            } else if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
            } else {
                throw new InvalidCommandException(command);
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
    }
}