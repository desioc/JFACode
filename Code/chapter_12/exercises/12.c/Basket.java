
import java.util.ArrayList;

public class Basket<F extends Fruit> {

    private ArrayList<F> fruit;

    public Basket() {
        fruit = new ArrayList<>();
    }

    public ArrayList<F> getFruit() {
        return fruit;
    }

    public void addFruit(F fruitItem) throws WeightException {
        final int newWeight = getWeight() + fruitItem.getWeight();
        if (newWeight > 2000) {
            throw new WeightException("Too heavy: " + newWeight + " grams!");
        }
        fruit.add(fruitItem);
        System.out.println(fruitItem.getWeight() + " gramms of "+ fruitItem.getClass().getName() +" added to basket");
    }

    public int getWeight() {
        int weight = 0;
        for (F fruit : fruit) {
            weight += fruit.getWeight();
        }
        return weight;
    }
}