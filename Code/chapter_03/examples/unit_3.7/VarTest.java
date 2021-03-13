package var; 

public class VarTest {
    public static void main(String args[]) {
        var obj1 = new JavaBook();
        var obj2 = getInstance();

        var bool = false; // type boolean inferred
        var string ="Foqus";// type String inferred
        var character= 'J'; // type char inferred
        var integer = 8; // type int inferred
        var byteInteger = (byte)8; // type byte inferred
        var shortInteger = (short)8; // type short inferred
        var longInteger = 8L; // type long inferred
        var floatingPoint = 3.14F; // type float inferred
        var doublePrecisionfloatingPoint = 3.14; // type double inferred

//        var notInitialized;
//        var nullInitialized = null;
//        var var1 = 1, var2 = 2;
//        var varArray[] = new int[3];
        var var = 0;

    }
    
    public void var() {
    }
    
    static JavaBook getInstance() {
        return new JavaBook();
    }
}
//class var {}
//interface var {}
//enum var {}
//@interface var {}

class JavaBook {
    public String title;
    public String author;
}