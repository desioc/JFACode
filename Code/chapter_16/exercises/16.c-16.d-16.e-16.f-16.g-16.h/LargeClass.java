package data;

import metadata.Bean;
import metadata.Short;
import metadata.Specification;

@Short
@Specification(3)
@Bean(methodsMaxNumber = 10, variablesMinNumber = 1)
public class LargeClass {

    public String variable1;
    public String variable2;

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }

    public void method3() {
        System.out.println("method3");
    }

    public void method4() {
        System.out.println("method4");
    }
}
