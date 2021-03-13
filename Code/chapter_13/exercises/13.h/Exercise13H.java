public class Exercise13H {
    public static void main(String args[]) {
        String string1 ="Claudio";
        String string2 = new String(string1);
        System.out.println(string2 == string1);
        System.out.println(string2.equals(string1));
        System.out.println("Claudio".equals(string1));
        System.out.println("Claudio" == string1);
        System.out.println("Claudio" == string2);
    }
}