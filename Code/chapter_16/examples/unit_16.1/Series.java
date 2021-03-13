import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)

public @interface Series {
  alphabet value();
  enum alphabet {A,B,C};
}