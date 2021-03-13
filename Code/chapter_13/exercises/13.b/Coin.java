import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coin other = (Coin) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }
}