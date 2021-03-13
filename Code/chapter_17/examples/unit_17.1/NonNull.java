/*
This is a utility annotation that simulates the NonNull annotation of the Checker Framework
*/

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface NonNull {
    
}