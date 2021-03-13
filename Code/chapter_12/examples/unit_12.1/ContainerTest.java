public class ContainerTest {
    public static void main(String args[]) {
        Container container = new Container();
        container.setObject("String");
        // container.setObject(new Integer(1));
        String object = (String)container.getObject();
        System.out.println(object);
    }
}