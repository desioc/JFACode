public class Exercise12P<T> {
    
    public static T[] getValues(T t){
        return t.values();
    }
    private enum T {
        T1, T2, T3;
    }
}