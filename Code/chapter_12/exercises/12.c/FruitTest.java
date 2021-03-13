public class FruitTest {
    public static void main(String args[]) {
        Basket<Apple> appleBasket = new Basket<>();
        for (int i = 0; i <= 20; i++) {
            try {
                Apple apple = new Apple(100);
                appleBasket.addFruit(apple);
            } catch (WeightException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}