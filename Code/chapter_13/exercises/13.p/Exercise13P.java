public class Exercise13P {
    public static void main(String args[]) throws CloneNotSupportedException {
        RTFText text = new RTFText("Java", Font.ARIAL, false);
        System.out.println(text);
        System.out.println(text.clone());
    }
}