import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)

public @interface SingleValue {
  foo value();
  enum foo {A,B,C};
}