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
}