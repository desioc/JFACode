public class Scale {
    private double weight;
    public Scale() {
        resetHand();
        assert handOnZero();// class invariant
    }
    private void setWeight(double grams) {
        assert grams > 0; // pre-condition
        weight = grams;
    }
    private double getWeight() {
        return weight;
    }
    public void weigh(double grams) {
        if (grams <= 0) {
            throw new RuntimeException("Grams <= 0! ");
        }
        setWeight(grams);
        showWeight();
        resetHand();
        assert handOnZero(); // Class invariant
    }
    private void showWeight() {
        System.out.println("The weight is " + weight + " grams");
    }
    private void resetHand() {
        setWeight(0);
    }
    private boolean handOnZero () {
        return weight == 0;
    }
}