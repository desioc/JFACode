public class GenericsContainer<T> {
    private T object;

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}