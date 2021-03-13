public class Exercise13M {
    public static void main(String args[]) {
        String string ="*** Java ***";
        string.toUpperCase();
        string.trim();
        string.substring(3, 8);
        string.trim();
        string.concat(String.format("String = %n", string.length()));
        string +="!";
        System.out.println(string.length);
    }
}