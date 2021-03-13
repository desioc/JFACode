import java.util.ArrayList;

class RunnableArrayList extends ArrayList implements Runnable {
    
    public void run(String string) {
        System.out.println("Within the run() method : "+ string);
    }
    
}

public class Exercise15E {
    public static void main(String args[]) {
        RunnableArrayList g = new RunnableArrayList();
        Thread t = new Thread(g);
        t.start();
    }
}