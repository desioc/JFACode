import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionTest {

    public static void main(String args[]) {
        //Coin coin = new Coin(Value.FIFTY_CENTS);
        Class<Coin> classCoin = Coin.class;

//        try {
//            classCoin.newInstance();
//        } catch (InstantiationException | IllegalAccessException ex) {
//            ex.printStackTrace();
//        }
        try {
            Constructor<Coin> costruttore = classCoin.getConstructor(Value.class);
            costruttore.newInstance(Value.FIFTY_CENTS);
        } catch (NoSuchMethodException | SecurityException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}