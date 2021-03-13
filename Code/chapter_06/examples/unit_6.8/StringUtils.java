public class StringUtils {
    public static int countOccurrences(String string, char character) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
//We could add other methods that performs operations on strings
}