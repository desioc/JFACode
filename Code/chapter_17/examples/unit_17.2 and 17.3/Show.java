import java.util.function.Supplier;
public class Show {
    public static void main(String args[]) {
        Guitarist guitar = new Guitarist();
        Supplier<Guitar> guitarSupplier = ()-> new Guitar("Ibanez");
        guitar.playGuitar(guitarSupplier);
    }
}