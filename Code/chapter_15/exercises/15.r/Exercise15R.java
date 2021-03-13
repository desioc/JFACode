import java.util.Date;

public final class Exercise15R {
    
    private final Integer integer;

    private final Date date;

    public Exercise15R(Integer integer, Date date){
        this.integer = integer;
        this.date = (Date)date.clone();
    }

    public final Date getStringBuilder() {
        return (Date)date.clone();
    }

    public final Integer getInteger() {
        return integer;
    }
}