import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
@Repeatable(Checks.class)
public @interface Check {
    String value();
}