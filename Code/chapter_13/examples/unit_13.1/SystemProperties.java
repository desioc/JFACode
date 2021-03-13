import java.util.*;

public class SystemProperties {
    public static void main(String args[]) {
        System.setProperty("claudio.surname","De Sio Cesari");
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("claudio.surname"));
        System.clearProperty("claudio.surname");
        System.out.println(System.getProperty("claudio.surname"));
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
}