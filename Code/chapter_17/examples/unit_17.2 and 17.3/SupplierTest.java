import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String args[]) {
        Guitarist guitarist = new Guitarist();
        Supplier<Guitar> guitarSupplier = ()-> new Guitar("Ibanez");
        guitarist.playGuitar(guitarSupplier);
    }
}