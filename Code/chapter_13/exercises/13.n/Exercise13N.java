public class Exercise13N {
    public static void main(String args[]) {
        String string ="Java";
        string = string.concat(" ");
        string += 9;
        String result = "";
        if (string.intern() == "Java for Aliens") {
            result += "intern()";
        } 
        if (string == "Java for Aliens") {
            result += "==";
        } 
        if (string.equals("Java for Aliens")) {
            result += "equals()";
        }
        System.out.println(result);
    }
}