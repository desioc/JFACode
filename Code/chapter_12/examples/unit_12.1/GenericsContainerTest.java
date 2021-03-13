public class GenericsContainerTest {
    public static void main(String args[]) {
        GenericsContainer<String> container = new GenericsContainer<>();
        container.setObject("String");//you can pass only strings
        String object = container.getObject();
        System.out.println(object);
        GenericsContainer<Integer> container2 = new GenericsContainer<Integer>();
        container2.setObject(new Integer("1"));//you can pass only integers
        Integer object2 = container2.getObject(); //no cast needed
        System.out.println(object2);
    }
}