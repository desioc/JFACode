public class MultipleInheritanceTest {
    public static void main(String args[]) {
        var you = new WhosReading();
        var java12 = new Book("Java 12","Claudio De Sio Cesari");
        you.read(java12);
        you.program("Java");
    }
}