package phonebook.test;

import phonebook.presentation.*;
import phonebook.data.*;
import phonebook.exceptions.*;
import java.util.*;

public class Exercise20P {
    
    private void executeTest() {
        PhonebookCLI cli = new PhonebookCLI();
        cli.start();
    }

    public static void main(String args[]) {
        Exercise20P exercise20P = new Exercise20P();
        exercise20P.executeTest();
    }
}