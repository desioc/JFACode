public enum MyEnumeration {
    ONE(1), TWO(2), THREE(3);
    
    private int value;
    
    MyEnumeration(int value) {
        setValue(value);
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String toString() {
        return ""+value;
    }
}