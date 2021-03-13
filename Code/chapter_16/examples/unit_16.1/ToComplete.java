import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ToComplete {
    String description();
    String assignedTo() default "yet to assign";
    enum Priority {HIGH, MEDIUM, LOW};
    Priority priority() default Priority.HIGH;
//    public static final int a = 0;
//    public static final class NestedClass {}
}