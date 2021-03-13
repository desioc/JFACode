public class GuitarFactoryImpl  implements GuitarFactory {
    @Override
    public Guitar getGuitar(String brand){
        return new Guitar(brand);
    }
}