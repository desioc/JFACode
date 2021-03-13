import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
@Repeatable(TestTriggers.class)
public @interface TestTrigger {
    String when();
    TestTool how() default TestTool.JUNIT;
    public enum TestTool {
        JUNIT, GUI, JMETER, SOAPUI;
    }
}