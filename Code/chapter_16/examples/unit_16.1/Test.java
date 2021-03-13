public class Test {
    @ToComplete(
        description ="We need to do something…",
        assignedTo ="Claudio"
    )
    enum Alphabet {
        A,B,C
    } ;
    public @interface Series {
        alphabet value();
        enum alphabet {
            A,B,C
        } ;
    }

    @SingleValue(value = SingleValue.foo.A)
    @ToComplete(
        description ="We need to do something…",
        assignedTo ="Claudio"
    )
    public Enum<Alphabet> doSomething() {
        System.out.println("I will do something...");
        return Alphabet.A;
    }
}