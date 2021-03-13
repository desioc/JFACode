package data;

import metadata.Bean;
import metadata.Short;
import metadata.Specification;

@Short
@Specification(1)
@Bean(methodsMaxNumber = 10, variablesMinNumber = 1)
public class ShortClass {

    public void method1() {
        System.out.println("method1");
    }
    private String variable;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
}