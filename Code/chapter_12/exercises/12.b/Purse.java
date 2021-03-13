import java.util.ArrayList;
import java.util.List;

/**
 * Abstracts the concept of a purse that can hold a limited number of
 * coins.
 *
 * @author Claudio De Sio Cesari
*/
public class Purse {

    /**
     * Constant that represents the maximum number of coins that this
     * purse can hold
    */
    private static final int DIMENSION = 10;

    /**
     * An array list that contains a limited number of coins.
     */
    private final List<Coin> coins = new ArrayList<>(DIMENSION);

    /**
      * Create a purse containing coins whose values are specified by the varargs 
      * values. lf the number of elements of the varargs values is greater than the maximum 
      * number of coins that the current purse can hold, then it is handled an exception
      *
      * @param values un varargs di values di coins.
     */
    public Purse(Value... values) {
        assert coins.size() <= DIMENSION;
        try {
            int numberOfCoins = values.length;
            for (int i = 0; i < numberOfCoins; i++) {
                if (i >= DIMENSION) {
                    throw new FullPurseException (
                        "Only the first 10 coins have been inserted!");
                }
                coins.add(new Coin(values[i]));
            }
        } catch (FullPurseException exc) {
            System.out.println(exc.getMessage());
        } catch (NullPointerException exc) {
            System.out.println("The purse has been created empty");
        }
        assert coins.size() <= DIMENSION;
    }

    /**
     * Adds a coin to the purse. If this is full the coin will not
     * be added and a significant error will be printed.
     * 
     * @param coin 
     *          the coin to add.
     * @throws FullPurseException
    */
    public void add(Coin coin) throws FullPurseException {
        try {
            System.out.println("Let's try adding one "+
                coin.getDescription());
        } catch (NullPointerException exc) {
            throw new NullCoinException();
        }
        int freeIndex = firstFreeIndex();
        if (freeIndex == -1) {
            throw new FullPurseException("Purse full! The coin "
                + coin.getDescription() +" has not been added!");
        } else {
            coins.set(freeIndex, coin);
            System.out.println(coin.getDescription() +" has been added");
        }
    }

 /**
     * Performs a withdrawal of the specified coin from the current coin purse. In
      * case the specified currency is not present, a significant error
      * will be printed and null will be returned.
     * 
     * @param coin
     *          the coin to take.
     * @return 
     *          the coin found.
     * @throws CoinNotFoundException if the coin is not found. 
    */
    public Coin withdraw(Coin coin) throws CoinNotFoundException {
        try {
            System.out.println("Let's try to get a "+
                coin.getDescription());
        } catch (NullPointerException exc) {
            throw new NullCoinException();
        }
        Coin foundCoin = null;
        int foundCoinIndex = foundCoinIndex(coin);
        if (foundCoinIndex == -1) {
            throw new CoinNotFoundException("Coin not found!");
        } else {
            foundCoin = coin;
            coins.set(foundCoinIndex, coin);
            System.out.println("One "+ coin.getDescription() +" withdrawn");
        }
        return foundCoin;
    }

   /**
     * Print the contents of the purse.
    */
    public void state() {
        System.out.println("The purse contains:");
        for (Coin coin : coins) {
            if (coin == null) {
                break;
            }
            System.out.println("One "+ coin.getDescription());
        }
    }

    /**
     * Retrieves the first free index in the coin array or -1 if the
      * coin purse is full.
     * 
     * @return 
     *          the first free index in the coin array or -1 if the
     *          coin purse is full.
     */
    private int firstFreeIndex() {
        int index = coins.indexOf(null);
        return index;
    }
    
    private int foundCoinIndex(Coin coin) {
        int foundCoinIndex = -1;
        final int size = coins.size();
        for (int i = 0; i < size; i++) {
            if (coins.get(i) == null) {
                continue;
            }
            Value coinInPurseValue = coins.get(i).getValue();
            Value value = coin.getValue();
            if (value == coinInPurseValue) {
                foundCoinIndex = i;
                break;
            }
        }
        return foundCoinIndex;
    }
}