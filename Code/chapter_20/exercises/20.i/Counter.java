package phonebook.util;

public class Counter {
    private static int objectCounter;
    
    public static int getSerialNumber() {
        return objectCounter+=1;
    }
}