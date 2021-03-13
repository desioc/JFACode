import java.util.prefs.Preferences;

public class PreferencesTest {
    private Preferences preferences;
    private final static String key1 = "key1";
    private final static String key2 = "key2";
    private final static String key3 = "key3";

    public PreferencesTest() {
        // Instance of Preferences.
        preferences = Preferences.userRoot().node(this.getClass().getName());
    }

    public void putPreferences() {
        // Let's set the the value with different types 
        preferences.putBoolean(key1, false);
        preferences.put(key2, "bar");
        preferences.putInt(key3, 100);
    }

    public void printPreferences() {
        // Let's print the key1 value, if we don't find it we will print the default true.
        System.out.println(preferences.getBoolean(key1, true));
        // Let's print the key2 value, if we don't find it we will print the default foo.
        System.out.println(preferences.get(key2, "foo"));
        // Let's print the key3 value, if we don't find it we will print the default 0.
        System.out.println(preferences.getInt(key3, 0));
    }
    
    public void removePreferences() {
        // Let's remove the key3 value
        preferences.remove(key3);
    }
    
    public static void main(String[] args) {
        TestPreferences test = new TestPreferences();
        test.putPreferences();
        test.printPreferences();
        test.removePreferences();
        test.printPreferences();
    }
}