public class Card {
    
    private Seed seed;
    private Number number;
    
    public Card (Number number, Seed seed) {
        this.number = number;
        this.seed = seed;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public Seed getSeed() {
        return seed;
    }
    
    public String toString() {
        return number + " of " + seed;
    }
}