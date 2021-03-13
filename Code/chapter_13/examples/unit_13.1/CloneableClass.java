public class CloneableClass implements Cloneable {
    private String field;

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
        /* CloneableClass cloneableClass = new CloneableClass();
        cloneableClass.setField(getField());
        return cloneableClass; */
    }
    
    @Override
    public String toString() {
        return "Object " + super.toString() + " - " + getField();
    }
}