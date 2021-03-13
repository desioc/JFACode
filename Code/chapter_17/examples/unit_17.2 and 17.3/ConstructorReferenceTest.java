public class ConstructorReferenceTest {
    public static void main(String args[]) {
//        GuitarFactory guitarFactory = (marca) -> { return new Guitar(marca); };
        GuitarFactory guitarFactory = Guitar::new;
        Guitar chitarra1 = guitarFactory.getGuitar("Fender");
        Guitar chitarra2 = guitarFactory.getGuitar("Ibanez");
        Guitar chitarra3 = guitarFactory.getGuitar("Gibson");
    }
}