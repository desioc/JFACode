abstract class Tool {
    public Tool() {
        doWork();
    }

    public void doWork() {
        System.out.println("Working...");
    }
}
class Hammer extends Tool {
    String data ="nail";
    public Hammer () {
        //chiamata implicita a super();
    }
    @Override
    public void doWork() {
        System.out.println("Hammering on "+ data);
    }
}
public class ToolsTest {
    public static void main(String[] args) {
        Tool tool = new Hammer();
    }
}