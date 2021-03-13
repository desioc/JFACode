import java.util.function.Supplier;

public class Guitarist {
    public void playGuitar(Supplier<Guitar> brandSupplier) {
        Guitar guitar = brandSupplier.get();
        guitar.play();
    }
}