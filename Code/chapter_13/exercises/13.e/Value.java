public enum Value {

    ONE_CENT(1) {
                @Override
                public String getDescriptiveString() {
                    return getValue() + " cents of ";
                }
            },
    TWO_CENTS(2),
    FIVE_CENTS(5),
    TEN_CENTS(10),
    TWENTY_CENTS(20),
    FIFTY_CENTS(50),
    ONE_EURO(1) {
                @Override
                public String getDescriptiveString() {
                    return getValue() + " ";
                }
            },
    TWO_EURO(2) {
                @Override
                public String getDescriptiveString() {
                    return getValue() + " ";
                }
            };

    private int value;

    private Value(int value) {
        this.value = value;
    }

    public String getDescriptiveString() {
        return getValue() + " cents of ";
    }

    public int getValue() {
        return value;
    }
}