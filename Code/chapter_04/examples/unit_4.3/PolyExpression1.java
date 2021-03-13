public class PolyExpression1 {
    public static void main(String args[]) {
        String integer ="2";
        int index = switch(integer) {
            case"1"-> {
                byte b = 1;
                System.out.println();
                break b;
            }
            case"2"-> {
                short s = 2;
                break s;
            }
            case"3"-> 3;
            default -> -1;
        } ;
    }
}