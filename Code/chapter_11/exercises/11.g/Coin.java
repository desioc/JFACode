public class Coin {

    public final static String CURRENCY = "EURO";

    private final Value value;

    public Coin(Value value) {
        this.value = value;
        System.out.println("Created a " + getDescription());
    }

    public Value getValue() {
        return value;
    }

    public String getDescription() {
        String description = "coin value " + value.getDescriptiveString()
                + CURRENCY;
        return description;
    }
}