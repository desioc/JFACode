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
        System.out.println("Created a "+ getDescription());
    }

    private static String formatDescriptiveString(int value) {
        String formattedString =" cents of ";
        if (value == 1) {
            formattedString =" cent of ";
        } else if (value > 99) {
            formattedString =" ";
            value /= 100;
        }
        return value + formattedString;
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

    /**
     * Retrieves the current coin description.
     * 
     * @return 
     *          the current coin description.
     */
    public String getDescription() {
        String description ="coin of "+ formatDescriptiveString(value)
        + CURRENCY;
        return description;
    }
}