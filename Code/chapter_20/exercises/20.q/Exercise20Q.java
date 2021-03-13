package phonebook.test;

import phonebook.presentation.*;
import phonebook.data.*;
import phonebook.exceptions.*;
import java.util.*;

public class Exercise20Q {
    
    private void executeTest() {
        PhonebookCLI cli = new PhonebookCLI();
        cli.start();
    }

    public static void main(String args[]) {
        Exercise20Q exercise20Q = new Exercise20Q();
        exercise20Q.executeTest();
    }
}