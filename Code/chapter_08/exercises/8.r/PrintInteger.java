public class PrintInteger extends PrintNumber{
    public void print(int number) {
        System.out.print(number);
    }
    
    public static void main(String args[]) {
        PrintNumber printNumber = new PrintInteger();
        printNumber.print(1);
    }
}