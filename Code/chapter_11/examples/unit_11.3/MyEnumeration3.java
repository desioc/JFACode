public enum MyEnumeration3 {
    ZERO(), ONE(1), TWO(2), THREE(3);
    private int value;
    private MyEnumeration3() {
    }
    MyEnumeration3(int value) {
      setValue(value);
    }
    public void setValue(int value){
      this.value = value;
    }
    public int getValue(){
      return this.value;
    }
    @Override
    public String toString() {
      return ""+value;
    }
}