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
    private static final String UPDATE_CONTACT ="/u";
    private static final String REMOVE_CONTACT ="/r";
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

    public void showContact(Contact contact) {
        try {
            System.out.println("Details of the contact selected:\n"+ contact);
            System.out.printf("Type '%s' to update the contact\n", UPDATE_CONTACT);
            System.out.printf("Type '%s' to remove the contact\n", REMOVE_CONTACT);
            System.out.printf("Type '%s' to go back and show contacts\n", BACK);
            String command = scanner.nextLine();
            controller.handleShowContact(command, contact);
        }
        catch (Exception exc) {
            showError(exc);
        }
    }

    public void updateContact(Contact contact) {
        try {
            String telephoneNumber = getContactData("telephone number");
            String address = getContactData("address");
            System.out.printf("Type '%s' to confirm the update\n", EXECUTE);
            System.out.printf("Type '%s' to go back and show contacts\n", BACK);
            String command = scanner.nextLine();
            controller.handleUpdateContact(command, contact.getName(), telephoneNumber, address);
        }
        catch (Exception exc) {
            showError(exc);
        }
    }

    public void removeContact(Contact contact) {
        try {
            System.out.printf("Type '%s' to confirm the removal\n", EXECUTE);
            System.out.printf("Type '%s'  to go back and show contacts\n", BACK);
            String command = scanner.nextLine();
            controller.handleRemoveContact(command, contact.getName());
        }
        catch (Exception exc) {
            showError(exc);
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
        System.out.println("Operation confirmed!");
        showMessage(message);
    }

    public void showError(Exception exc) {
        System.out.println("There's a problem!");
        showMessage(exc.toString());
    }

    private void showMessage(String message) {
        try {
            System.out.println(message +"\n");
            System.out.printf("Type '%s'  to go back and show contacts\n", BACK);
            System.out.printf("Type '%s' to terminate the program\n", END);
            String command = scanner.nextLine();
            controller.handleShowMessage(command);
        }
        catch (Exception exc) {
            showMessage(message);
        }
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

        public void handleShowContacts(String command, List<Contact> contacts) throws IOException, ClassNotFoundException {
            if (command.equals(INSERT)) {
                insertContact();
            } else if (command.equals(END)) {
                System.out.println("Program terminated");
                System.exit(1);
            } else if (isValidCommandToShowAContact(contacts, command)) {
                String contactName = extractContactName(command);
                System.out.printf("Show contact method called for %s\n", contactName);
                Contact contact = fileManager.retrieve(contactName);
                showContact(contact);
            } else {
                throw new InvalidCommandException(command);
            }
        }


        public void handleShowContact(String command,Contact contact) throws IOException, ClassNotFoundException  {
            if (command.equals(UPDATE_CONTACT)) {
                updateContact(contact);
            } else if (command.equals(REMOVE_CONTACT)) {
                removeContact(contact);
            } else if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
            } else {
                throw new InvalidCommandException(command);
            }
        }
        
        public void handleInsertContact(String command, String name,  String telephoneNumber, String address) throws IOException, EmptyNameException{
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
        
       public void handleUpdateContact(String command, String name, String telephoneNumber, String address) throws IOException, EmptyNameException  {
            if (command.equals(EXECUTE)) {
                Contact contact = new Contact(name, telephoneNumber, address);
                fileManager.update(contact);
                showConfirmation("Update confirmed:\n"+ contact);
            } else if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
            } else {
                throw new InvalidCommandException(command);
            }
        }

        public void handleRemoveContact(String command, String name) throws IOException {
            if (command.equals(EXECUTE)) {
                fileManager.remove(name);
                showConfirmation("Removal confirmed:\n"+ name);
            } else if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
            } else {
                throw new InvalidCommandException(command);
            }
        }
       
        public void handleShowMessage(String command) throws IOException {
            if (command.equals(BACK)) {
                showContacts(fileManager.getContacts());
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