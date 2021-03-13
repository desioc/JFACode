public class PrinterTest {
    public static void main(String args[]) {
        Printer<Laser> printer = new Printer<>(new Laser());
        printer.print();
        Printer<Inkjet> printer2 = new Printer<>(new Inkjet());
        printer2.print();
    }
}