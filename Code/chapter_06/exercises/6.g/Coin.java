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
    private final int value;

    /**
     * Constructor that takes as input the coin value.
     *
     * @param value ithe coin value.
     */
    public Coin(int value) {
        this.value = value;
        System.out.println("Created a "+ formatMeasurementUnit(value) + 
        CURRENCY + " coin ");
    }

    private static String formatMeasurementUnit(int value) {
        return value + (value == 1 ?  " cent of " : " cents of ");
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