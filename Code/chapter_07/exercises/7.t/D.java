// you can declare multiple types in the same file,
// provided that only one is declared public (and the
// file must have the name of the public type)

interface A {
    void method();
}

interface B extends A {}

abstract class C implements B {}

public final class D extends C {
    public void method(){}
}