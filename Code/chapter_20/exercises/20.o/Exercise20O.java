package phonebook.test;

import phonebook.presentation.*;
import phonebook.data.*;
import phonebook.exceptions.*;
import java.util.*;

public class Exercise20O {
    
    private void executeTest() {
        PhonebookCLI cli = new PhonebookCLI();
        cli.start();
    }

    public static void main(String args[]) {
        Exercise20O exercise20O = new Exercise20O();
        exercise20O.executeTest();
    }
}