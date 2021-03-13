public class Exercise9S {
    public static void main(String args[]) throws NullPointerException {
        Exercise9S e = new Exercise9S();
        e.method();
    }

    public NullPointerException method() throws Exception  {
        String s = null;
        try {
            s.toString();
        } catch(ArithmeticException e) {
            throw new NullPointerException ();
        }
        return null;
    }
}