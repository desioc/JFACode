public class Exercise15RNonImmutabile {
    
    private Integer integer;

    private StringBuilder stringBuilder;

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }
}