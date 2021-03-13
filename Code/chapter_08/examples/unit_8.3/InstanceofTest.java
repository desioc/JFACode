import java.util.*;

public class InstanceofTest {
    public static void main(String args[]) {
        InstanceofTest test = new InstanceofTest();
        //System.out.println(test instanceof ArrayList);
        System.out.println(test instanceof Runnable);
        List list  = new ArrayList();
        System.out.println(list instanceof Runnable);
        Runnable r = new Thread();
        System.out.println(r instanceof ArrayList);
        String s = "reH Dunmo' law' tlhIngan";
//        System.out.println(s instanceof Runnable); 
         System.out.println(s instanceof String); 
    }
}
class InstanceofTestRunnable extends InstanceofTest implements Runnable{
    public void run() {}
}
