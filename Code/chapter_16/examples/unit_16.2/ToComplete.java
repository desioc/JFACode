import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
@Target({TYPE, METHOD, CONSTRUCTOR, PACKAGE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ToComplete {
    String description();
    String assignedTo() default "yet to assign";
    enum Priority {HIGH, MEDIUM, LOW};
    Priority priority() default Priority.HIGH;
}