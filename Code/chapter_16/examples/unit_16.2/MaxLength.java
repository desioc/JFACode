import java.lang.annotation.*;
/**
  It allows the control of the maximum length of a field
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxLength {
    int value();
}