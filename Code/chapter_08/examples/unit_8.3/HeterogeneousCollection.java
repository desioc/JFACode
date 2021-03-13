import java.util.Date;

public class HeterogeneousCollection {
    public static void main(String args[]) {
        Object arr[] = new Object[3];
        arr[0] = new Point();    //arr[0], arr[1], arr[2]
        arr[1] ="Hello World!";  //are references of type Object
        arr[2] = new Date();     //that targets objects created from subclasses
//        Object arr[]= {
//            new Point(),"Hello World!", new Date()
//        } ;

    }
}