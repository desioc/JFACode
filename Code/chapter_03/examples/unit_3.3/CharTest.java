public class CharTest {
    public static void main(String args[]) {
        char firstCharacter= 'a';
        String s ="Java melius semper quam latinam linguam est";

        //char c = "C";
        //String s = 'Meum filium maxime amo, sed ille me latinam linguam studere compellit';

        char aUppercase = 'A';
        char minus = '-';
        char at = '@';

        int i = 1;
        char a = 'A';
        char b = (char)(a+i); // c = 'B'!
        //char b = a+i;
        int ii = a+i;
        char phiGreekCharacter = '\u03A6';  
        char nonIdentifiedUnicodeCharacter = '\uABC8';

        char zero = '\u0030'; //the hexadecimal number 30 is equal to the decimal number 48
        //char zero = '0';
        System.out.println(zero);

        System.out.println('"');
        
        char doubleQuotes = '"';
        System.out.println(doubleQuotes);

        //System.out.println(''');
        
        System.out.println("'IQ'");
        
        System.out.println("\"IQ\"");
    }
}