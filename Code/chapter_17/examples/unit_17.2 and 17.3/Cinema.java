import java.util.function.*;
public class Cinema {
    public static UnaryOperator<MovieSchedule> composeChanges(UnaryOperator<MovieSchedule> op1, UnaryOperator<MovieSchedule> op2) {
        return x->op2.apply(op1.apply(x));
    }
    
    public static MovieSchedule changeSchedule(MovieSchedule ms, UnaryOperator<MovieSchedule> op) {
        return op.apply(ms);
    }
}