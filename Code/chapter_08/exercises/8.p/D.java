interface A {
    void method();
}

interface B extends A {
    static void staticMethod(){}
}

final class C implements B {}

public abstract class D implements A {
    @Override
    void method(){}
}