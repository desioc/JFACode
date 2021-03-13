import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

public class TestReadRepeatable {
    public static void main(String args[]) {
        Class<TestRepeatable> testRepeatableClass =  TestRepeatable.class;
        TestTriggers [] annotations = testRepeatableClass.getAnnotationsByType(TestTriggers.class);
        for (TestTriggers testTriggers: annotations) {
            TestTrigger[] values = testTriggers.value();
            for(TestTrigger testTrigger: values) {
                String when = testTrigger.when();
                TestTrigger.TestTool how = testTrigger.how();
                System.out.println(when);
                System.out.println(how);
                interpretWhen(when);
                interpretHow(how);
            }
        }
    }

    public static void interpretWhen(String when) {
        StringTokenizer st = new StringTokenizer(when);
        if (Objects.nonNull(st)) {
            // complex code that interprets the string
             // and program the execution of the test
        }
        //. . . 
    }

    public static void interpretHow(TestTrigger.TestTool come) {
         // The complex code that records the test tool for this case
    }
}