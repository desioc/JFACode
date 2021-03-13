/**
 * This class abstract the concept of Coin.
 *
 * @author Claudio De Sio Cesari
 */
public class Coin {

    /**
     * The currency is a constant set to EURO.
    */
    public final static String CURRENCY ="EURO";

    /**
     * Represents the coin value in cents.
    */
    private int value;

    /**
     * Constructor that takes as input the coin value.
     *
     * @param value ithe coin value.
     */
    public Coin(int value) {
        this.value = value;
        System.out.println("Created a coin from "+ value +" cents ");
    }

    /**
     * Set the value instance variable.
     *
     * @param value contains the value at which the value 
     * of the  instance variable value has to be set.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Retrieves the value instance variable.
     * 
     * @return
     *          the value instance variable
     */
    public int getValue() {
        return value;
    }    
}