/**
 * Abstracts the concept of purse that can contain a limited number of coins.
 * 
 * @author Claudio De Sio Cesari
 */
public class Purse {

    /**
     * An array that can contain a limited number of coins.
     */
    private final Coin[] coins = new Coin[10];

    /**
     * Create a Purse object containing coins whose values are
      * specified by the values varargs .
     * 
     * @param values
     *          a varargs of coin values .
     */
    public Purse(int... values){
        int numberOfCoins = values.length;
        for (int i = 0; i < numberOfCoins; i++) {
            if (i >= 10) {
                System.out.println(
              "Only the first 10 coins were inserted!");
                break;
            }
            coins[i] = new Coin(values[i]);
        }    
    }
    /**
     * Adds a coin to the purse. If this is full the coin will not
     * be added and a significant error will be printed.
     * 
     * @param coin 
     *          the coin to add.
     */
    public void add(Coin coin) {
        System.out.println("Let's try adding one " + 
                    coin.getDescription());
        int freeIndex = firstFreeIndex();
        if (freeIndex == -1) {
            System.out.println("Purse full! The coin " + 
                    coin.getDescription() + " has not been added!");
        } else {
            coins[freeIndex] = coin;
            System.out.println(coin.getDescription() + " has been added");
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
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (coins[i] == null) {
                index = i;
                break;
            }
        }
        return index;
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
            System.out.println("One " + coin.getDescription());
        }
    }
}