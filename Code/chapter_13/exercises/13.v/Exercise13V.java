public class Exercise13V {
    public static void main(String args[]) {
        Exercise13V e = new Exercise13V();
        e.method(128);
    }
    
    public void method(Integer number) {
        System.out.println("Integer " + number);
    }
    public void method(long number) {
        System.out.println("long " + number);
    }
    public void method(byte number) {
        System.out.println("byte " + number);
    }
    public void method(Byte number) {
        System.out.println("Byte " + number);
    }
    public void method(short number) {
        System.out.println("short " + number);
    }
    public void method(Double number) {
        System.out.println("Double " + number);
    }
    public void method(double number) {
        System.out.println("double " + number);
    }
}